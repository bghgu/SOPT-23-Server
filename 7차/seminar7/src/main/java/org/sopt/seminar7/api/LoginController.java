package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.model.SignUpReq;
import org.sopt.seminar7.service.LoginService;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.sopt.seminar7.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-11-28.
 */

@Slf4j
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(final LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 로그인
     *
     * @param signUpReq 로그인 폼
     * @return ResponseEntity
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody final SignUpReq signUpReq) {
        try {
            return new ResponseEntity<>(loginService.login(signUpReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
