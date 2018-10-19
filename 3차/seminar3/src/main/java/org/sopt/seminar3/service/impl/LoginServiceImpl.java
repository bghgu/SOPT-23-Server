package org.sopt.seminar3.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.service.LoginService;
import org.sopt.seminar3.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by ds on 2018-10-19.
 */

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public DefaultRes login() {
        log.info("login");
        return DefaultRes.builder()
                .statusCode(HttpStatus.OK.value())
                .responseMessage(ResponseMessage.LOGIN_SUCCESS)
                .build();
    }

    @Override
    public DefaultRes logout() {
        log.info("logout");
        return DefaultRes.builder()
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .responseMessage(ResponseMessage.LOGIN_FAIL)
                .build();
    }
}
