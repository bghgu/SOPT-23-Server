package org.sopt.seminar3.service.impl;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ds on 2018-10-19.
 */

@Service(value = "UserServiceImpl2")
public class UserServiceImpl2 implements UserService {

    @Override
    public DefaultRes<List<User>> findAllUser() {
        return null;
    }

    @Override
    public DefaultRes<User> findOneUser(int userIdx) {
        return null;
    }

    @Override
    public DefaultRes<User> saveUser(User user) {
        return null;
    }

    @Override
    public DefaultRes<User> updateUser(int userIdx, User user) {
        return null;
    }

    @Override
    public DefaultRes<User> deleteUser(int userIdx) {
        return null;
    }
}
