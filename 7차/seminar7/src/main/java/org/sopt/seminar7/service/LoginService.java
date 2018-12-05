package org.sopt.seminar7.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.mapper.UserMapper;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.model.SignUpReq;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.springframework.stereotype.Service;

/**
 * Created by ds on 2018-11-30.
 */

@Slf4j
@Service
public class LoginService {

    private final UserMapper userMapper;

    private final JwtService jwtService;

    public LoginService(final UserMapper userMapper, final JwtService jwtService) {
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    /**
     * 로그인
     *
     * @param signUpReq 로그인 폼
     * @return DefaultRes
     */
    public DefaultRes login(final SignUpReq signUpReq) {
        if (signUpReq.isLogin()) {
            final User user = userMapper.findByEmailAndPassword(signUpReq);
            if (user != null) {
                final JwtService.TokenRes tokenRes = new JwtService.TokenRes(jwtService.create(user.getUserIdx()));
                return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, tokenRes);
            }
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL);
    }
}
