package org.sopt.seminar4.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar4.dto.User;

import java.util.List;

/**
 * Created by ds on 2018-11-05.
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
    @Insert("INSERT INTO user(name, part) VALUES(#{name}, #{part})")
    @Options(useGeneratedKeys = true, keyColumn = "userIdx")
    void save(final User user);

    //회원 정보 수정
    @Update("UPDATE user SET name = #{name}, part = #{part} WHERE userIdx = #{userIdx}")
    void update(final User user);

    //회원 삭제
    @Delete("DELETE FROM user where userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);
}
