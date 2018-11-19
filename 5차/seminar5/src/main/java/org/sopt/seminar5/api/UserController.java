package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.SignUpReq;
import org.sopt.seminar5.service.JwtService;
import org.sopt.seminar5.service.UserService;
import org.sopt.seminar5.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.sopt.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-11-12.
 */

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name") final Optional<String> name) {
        try {
            //name이 null일 경우 false, null이 아닐 경우 true
            if (name.isPresent()) return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("test1")
    public String test1(final SignUpReq signUpReq) {
        //application/x-www-form-urlecoded 형식
        return signUpReq.toString();
    }

    @PostMapping("test2")
    public String test2(@RequestBody final SignUpReq signUpReq) {
        //application/json 객체 형식
        return signUpReq.toString();
    }


    /**
     * 회원 가입
     *
     * @param signUpReq 회원 가입 폼
     * @param profile   프로필 사진 객체
     * @return ResponseEntity
     */
    //@RequestPart
    //value = "profile" 파일의 키 값은 profile
    //required = false 파일을 필수로 받지 않겠다.
    @PostMapping("")
    public ResponseEntity signup(
            SignUpReq signUpReq,
            @RequestPart(value = "profile", required = false) final MultipartFile profile
    ) {
        try {
            System.out.println("asdasdas");
            //파일을 signUpReq에 저장
            if (profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.save(signUpReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userIdx}")
    public ResponseEntity signUp(
            @PathVariable(value = "userIdx") final int userIdx,
            @RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.update(userIdx, user), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx") final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}