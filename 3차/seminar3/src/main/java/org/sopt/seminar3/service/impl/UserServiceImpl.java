package org.sopt.seminar3.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.sopt.seminar3.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2018-10-19.
 */

@Slf4j
@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAllUser() {
        log.info("findAllUser");
        if (userList.isEmpty())
            return DefaultRes.<List<User>>builder()
                    .statusCode(HttpStatus.OK.value())
                    .responseMessage(ResponseMessage.NOT_FOUND_USER)
                    .build();
        return DefaultRes.<List<User>>builder()
                .statusCode(HttpStatus.OK.value())
                .responseMessage(ResponseMessage.FIND_ALL_USERS)
                .responseData(userList)
                .build();
    }

    @Override
    public DefaultRes<User> findOneUser(final int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx)
                return DefaultRes.<User>builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseMessage.FIND_USER)
                        .responseData(u)
                        .build();
        }
        return DefaultRes.<User>builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .responseMessage(ResponseMessage.NOT_FOUND_USER)
                .build();
    }

    @Override
    public DefaultRes<User> saveUser(final User user) {
        for(User u : userList) {
            if (u.getUserIdx() == user.getUserIdx())
                return DefaultRes.<User>builder()
                    .statusCode(HttpStatus.OK.value())
                    .responseMessage(ResponseMessage.ALREADY_USER)
                    .build();
        }
        userList.add(user);
        return DefaultRes.<User>builder()
                .statusCode(HttpStatus.NO_CONTENT.value())
                .responseMessage(ResponseMessage.CREATED_USER)
                .build();
    }

    @Override
    public DefaultRes<User> updateUser(final int userIdx, final User user) {
        for(User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                userList.add(user);
                return DefaultRes.<User>builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseMessage.UPDATE_USER)
                        .build();
            }
        }
        return DefaultRes.<User>builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .responseMessage(ResponseMessage.NOT_FOUND_USER)
                .build();
    }

    @Override
    public DefaultRes<User> deleteUser(final int userIdx) {
        for(User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                return DefaultRes.<User>builder()
                        .statusCode(HttpStatus.OK.value())
                        .responseMessage(ResponseMessage.DELETE_USER)
                        .build();
            }
        }
        return DefaultRes.<User>builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .responseMessage(ResponseMessage.NOT_FOUND_USER)
                .build();
    }

}
