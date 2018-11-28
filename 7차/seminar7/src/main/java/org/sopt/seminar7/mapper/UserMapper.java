package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar7.dto.User;

/**
 * Created by ds on 2018-11-28.
 */

@Mapper
public interface UserMapper {

    @Select("")
    User findByUserIdx(@Param("userIdx") final int userIdx);
}
