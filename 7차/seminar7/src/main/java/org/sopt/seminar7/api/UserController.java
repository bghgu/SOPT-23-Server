package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.model.SignUpReq;
import org.sopt.seminar7.service.JwtService;
import org.sopt.seminar7.service.UserService;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.sopt.seminar7.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.sopt.seminar7.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-11-28.
 */

@Slf4j
@RestController
public class UserController {

    private static final DefaultRes UNAUTHORIZED_RES = new DefaultRes(StatusCode.UNAUTHORIZED, ResponseMessage.UNAUTHORIZED);

    private final UserService userService;

    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/users/{userIdx}")
    public ResponseEntity getUser(
            @RequestHeader(value = "Authorization", required = false) final String header,
            @PathVariable("userIdx") final int userIdx) {
        try {
            final int tokenValue = jwtService.decode(header).getUser_idx();
            DefaultRes<User> defaultRes = userService.findByUserIdx(userIdx);
            if (tokenValue == userIdx) defaultRes.getData().setAuth(true);
            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(
            SignUpReq signUpReq,
            @RequestPart("profile") final Optional<MultipartFile> profile) {
        try {
            if(profile.isPresent()) signUpReq.setProfile(profile.get());
            return new ResponseEntity<>(userService.save(signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PutMapping("/users/{userIdx}")
    public ResponseEntity updateUser(
            @RequestHeader(value = "Authorization") final String header,
            @PathVariable("userIdx") final int userIdx,
            SignUpReq signUpReq,
            @RequestPart("profile") final Optional<MultipartFile> profile) {
        try {
            if(profile.isPresent()) signUpReq.setProfile(profile.get());

            if(jwtService.checkAuth(header, userIdx))
                return new ResponseEntity<>(userService.update(userIdx, signUpReq), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @DeleteMapping("/users/{userIdx}")
    public ResponseEntity deleteUser(
            @RequestHeader(value = "Authorization") final String header,
            @PathVariable("userIdx") final int userIdx) {
        try {
            if(jwtService.checkAuth(header, userIdx))
                return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
