package org.sopt.seminar3.lombok;

import org.sopt.seminar3.model.DefaultRes;

/**
 * Created by ds on 2018-10-19.
 */
public interface LoginService {
    DefaultRes login();
    DefaultRes logout();
}
