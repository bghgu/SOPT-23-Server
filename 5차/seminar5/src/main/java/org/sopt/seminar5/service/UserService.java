package org.sopt.seminar5.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.mapper.UserMapper;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.model.SignUpReq;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by ds on 2018-11-12.
 */

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    private final S3FileUploadService s3FileUploadService;

    /**
     * 생성자 의존성 주입
     *
     * @param userMapper
     * @param s3FileUploadService
     */
    public UserService(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    /**
     * 모든 회원 조회
     *
     * @return DefaultRes
     */
    public DefaultRes getAllUsers() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }

    /**
     * 이름으로 회원 조회
     *
     * @param name 이름
     * @return DefaultRes
     */
    public DefaultRes findByName(final String name) {
        final User user = userMapper.findByName(name);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }

    /**
     * 회원 가입
     *
     * @param signUpReq 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes save(SignUpReq signUpReq) {
        try {
            //파일이 있다면 파일을 S3에 저장 후 경로를 저장
            if (signUpReq.getProfile() != null)
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));

            userMapper.save(signUpReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 정보 수정
     *
     * @param userIdx 회원 고유 번호
     * @param user    수정할 회원 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes update(final int userIdx, final User user) {
        User temp = userMapper.findByUserIdx(userIdx);
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            if (user.getName() != null) temp.setName(user.getName());
            if (user.getPart() != null) temp.setPart(user.getPart());
            userMapper.update(userIdx, temp);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 탈퇴
     *
     * @param userIdx 회원 고유 번호
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes deleteByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if (user == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            userMapper.deleteByUserIdx(userIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        } catch (Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}