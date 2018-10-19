package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;

import java.util.List;

/**
 * Created by ds on 2018-10-19.
 */

public interface UserService {
    DefaultRes<List<User>> findAllUser();
    DefaultRes<User> findOneUser(final int userIdx);
    DefaultRes<User> saveUser (final User user);
    DefaultRes<User> updateUser (final int userIdx, User user);
    DefaultRes<User> deleteUser (final int userIdx);
}
