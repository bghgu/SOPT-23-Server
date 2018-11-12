package org.sopt.seminar5.utils.auth;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.mapper.UserMapper;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.service.JwtService;
import org.sopt.seminar5.service.UserService;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ds on 2018-11-13.
 */

@Slf4j
@Component
@Aspect
public class AuthAspect {

    private final static String AUTHORIZATION = "Authorization";

    /**
     * 실패 시 기본 반환 Response
     */
    private final static DefaultRes DEFAULT_RES = DefaultRes.builder().status(401).message("인증 실패").build();
    private final static ResponseEntity<DefaultRes> RES_RESPONSE_ENTITY = new ResponseEntity<>(DEFAULT_RES, HttpStatus.UNAUTHORIZED);

    private final HttpServletRequest httpServletRequest;

    private final UserMapper userMapper;

    private final JwtService jwtService;

    /**
     * Repository 의존성 주입
     */
    public AuthAspect(final HttpServletRequest httpServletRequest, final UserMapper userMapper, final JwtService jwtService) {
        this.httpServletRequest = httpServletRequest;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    /**
     * 토큰 유효성 검사
     * @param pjp
     * @return
     * @throws Throwable
     */
    //항상 @annotation 패키지 이름을 실제 사용할 annotation 경로로 맞춰줘야 한다.
    @Around("@annotation(org.sopt.seminar5.utils.auth.Auth)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        final String jwt = httpServletRequest.getHeader(AUTHORIZATION);

        //토큰 존재 여부 확인
        if (jwt == null) {
            return RES_RESPONSE_ENTITY;
        }

        //토큰 해독
        final JwtService.Token token = jwtService.decode(jwt);

        //토큰 검사
        if (token == null) {
            return RES_RESPONSE_ENTITY;
        } else {
            final User user = userMapper.findByUserIdx(token.getUser_idx());

            //유효 사용자 검사
            if (user == null) {
                return RES_RESPONSE_ENTITY;
            }

            return pjp.proceed(pjp.getArgs());
        }

    }
}
