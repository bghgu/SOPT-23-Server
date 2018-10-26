package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2018-10-26.
 */

@Service
public class UserService2 {

    private static final List<User> userList = new LinkedList<>();

    public DefaultRes<List<User>> findAll() {
        if (userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트가 비었습니다.");
        return DefaultRes.res(HttpStatus.OK.value(), "리스트 조회 성공", userList);
    }

    public DefaultRes<User> findByUserIdx(final int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx)
                return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", u);
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }

    public DefaultRes<User> save(final User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.NO_CONTENT.value(), "회원 가입 성공");
    }

    public DefaultRes<User> update(final int userIdx, final User user) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                userList.add(user);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 수정 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }

    public DefaultRes<User> deleteByUserIdx(final int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 삭제 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }
}
