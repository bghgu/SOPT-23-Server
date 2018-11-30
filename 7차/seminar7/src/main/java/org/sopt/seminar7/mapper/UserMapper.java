package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.model.SignUpReq;

/**
 * Created by ds on 2018-11-28.
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE email = #{signUpReq.email} AND password = #{signUpReq.password}")
    User findByEmailAndPassword(@Param("signUpReq") final SignUpReq signUpReq);

    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);
}
