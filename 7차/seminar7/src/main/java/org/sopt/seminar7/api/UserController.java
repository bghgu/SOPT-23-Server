package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.model.SignUpReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * Created by ds on 2018-11-28.
 */

@Slf4j
@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity saveUser(
            SignUpReq signUpReq,
            @RequestPart("profile") final Optional<MultipartFile> profile) {
        log.info(signUpReq.toString());
        if(profile.isPresent()) log.info(profile.get().getOriginalFilename());
        return new ResponseEntity(HttpStatus.OK);
    }
}
