package org.sopt.seminar5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.SignUpReq;

import java.util.List;

/**
 * Created by ds on 2018-11-12.
 */

@Mapper
public interface UserMapper {

    //모든 회원 리스트 조회
    @Select("SELECT * FROM user")
    List<User> findAll();

    //회원 이름으로 조회
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    //회원 고유 번호로 조회
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);

    //회원 등록, Auto Increment는 회원 고유 번호
    //Auto Increment 값을 받아오고 싶으면 리턴 타입을 int(Auto Increment 컬럼 타입)으로 하면 된다.
    @Insert("INSERT INTO user(name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int save(@Param("signUpReq") final SignUpReq signUpReq);

    //Auto Increment 값을 받아오고 싶지 않다면 필요 없다.
    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    void save2(@Param("user") final User user);

    //회원 정보 수정
    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE userIdx = #{userIdx}")
    void update(@Param("userIdx") final int userIdx, @Param("user") final User user);

    //회원 삭제
    @Delete("DELETE FROM user where userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);
}