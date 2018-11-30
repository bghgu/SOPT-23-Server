package org.sopt.seminar7.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.mapper.UserMapper;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.model.SignUpReq;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by ds on 2018-11-30.
 */

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;
    private final S3FileUploadService s3FileUploadService;

    public UserService(final UserService userService, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userService;
        this.s3FileUploadService = s3FileUploadService;
    }


    public DefaultRes<User> findByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if(user != null) DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
        return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
    }

    @Transactional
    public DefaultRes save(SignUpReq signUpReq) {
        if (signUpReq.checkProperties()) {
            final User user = userMapper.findByEmail(signUpReq.getEmail());
            if (user == null) {
                try {
                    if (signUpReq.getProfile() != null)
                        signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
                    userMapper.save(signUpReq);
                    return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
                }
            } else return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.ALREADY_USER);
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.FAIL_CREATE_USER);
    }

    @Transactional
    public DefaultRes<User> update(final int userIdx, SignUpReq signUpReq) {
        User temp = findByUserIdx(userIdx).getData();
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            //temp.update(signUpReq);
            //if (signUpReq.getProfile() != null) temp.setU_profile(fileUploadService.upload(signUpReq.getProfile()));

            //userMapper.update(temp);

            temp = findByUserIdx(userIdx).getData();
            temp.setAuth(true);
            return DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_USER, temp);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Transactional
    public DefaultRes deleteByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if (user != null) {
            try {
                userMapper.deleteByUserIdx(userIdx);
                return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
            } catch (Exception e) {
                log.error(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
            }
        }
        return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
    }
}
