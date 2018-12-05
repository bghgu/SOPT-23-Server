package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(@Param("email") final String email);

    @Insert("INSERT INTO user(name, email, password, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.email}, #{signUpReq.password}, #{signUpReq.profileUrl})")
    void save(@Param("signUpReq") final SignUpReq signUpReq);

    @Update("UPDATE user SET name = #{user.name}, profileUrl = #{user.profileUrl} WHERE userIdx = #{userIdx}")
    void update(@Param("user") final SignUpReq signUpReq, @Param("userIdx") final int userIdx);

    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);
}
