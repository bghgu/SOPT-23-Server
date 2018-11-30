package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.sopt.seminar7.model.SignUpReq;
import org.sopt.seminar7.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * Created by ds on 2018-11-28.
 */

@Slf4j
@RestController
public class UserController {

    @GetMapping("/users/{userIdx}")
    public ResponseEntity getUser(@PathVariable("userIdx") final int userIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(
            SignUpReq signUpReq,
            @RequestPart("profile") final Optional<MultipartFile> profile) {
        if(profile.isPresent()) signUpReq.setProfile(profile.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Auth
    @PutMapping("/users/{userIdx}")
    public ResponseEntity updateUser(
            @PathVariable("userIdx") final int userIdx,
            SignUpReq signUpReq,
            @RequestPart("profile") final Optional<MultipartFile> profile) {
        if(profile.isPresent()) signUpReq.setProfile(profile.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Auth
    @DeleteMapping("/users/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable("userIdx") final int userIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
