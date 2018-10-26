package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;

import java.util.List;

/**
 * Created by ds on 2018-10-19.
 */

public interface UserService {
    //전체 User 조회
    DefaultRes<List<User>> findAll();
    //userIdx로 User 조회
    DefaultRes<User> findByUserIdx(final int userIdx);
    //User 저장
    DefaultRes save (final User user);
    //User 수정
    DefaultRes<User> update (final int userIdx, final User user);
    //userIdx로 User 삭제
    DefaultRes deleteByUserIdx (final int userIdx);
}
