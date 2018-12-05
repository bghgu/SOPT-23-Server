package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.model.SignUpReq;

/**
 * Created by ds on 2018-11-28.
 */

@Mapper
public interface UserMapper {

    /**
     * email & 비밀번호
     *
     * @param signUpReq 로그인 폼
     * @return User
     */
    @Select("SELECT * FROM user WHERE email = #{signUpReq.email} AND password = #{signUpReq.password}")
    User findByEmailAndPassword(@Param("signUpReq") final SignUpReq signUpReq);

    /**
     * 회원 조회
     *
     * @param userIdx 회원 고유 번호
     * @return User
     */
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);

    /**
     * 이메일 중복 검사
     *
     * @param email email
     * @return User
     */
    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(@Param("email") final String email);

    /**
     * 회원 가입
     *
     * @param signUpReq 회원 가입 데이터
     */
    @Insert("INSERT INTO user(name, email, password, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.email}, #{signUpReq.password}, #{signUpReq.profileUrl})")
    void save(@Param("signUpReq") final SignUpReq signUpReq);

    /**
     * 회원 정보 수정
     *
     * @param signUpReq 회원 정보 데이터
     * @param userIdx   회원 고유 번호
     */
    @Update("UPDATE user SET name = #{user.name}, profileUrl = #{user.profileUrl} WHERE userIdx = #{userIdx}")
    void update(@Param("user") final SignUpReq signUpReq, @Param("userIdx") final int userIdx);

    /**
     * 회원 삭제
     *
     * @param userIdx 회원 고유 번호
     */
    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);
}
