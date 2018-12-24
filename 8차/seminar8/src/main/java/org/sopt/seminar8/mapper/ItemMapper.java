package org.sopt.seminar8.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar8.domain.Item;

import java.util.List;

/**
 * Created by ds on 2018-12-24.
 */

/**
 * myBatis
 */

@Mapper
public interface ItemMapper {

    @Select("SELECT * FROM item")
    List<Item> findAll();

    @Insert("INSERT INTO item(name) VALUES(#{item.name})")
    void save(@Param("item") final Item item);

    @Delete("DELETE FROM item WHERE name = #{name}")
    void deleteByName(@Param("name") final String name);
}
