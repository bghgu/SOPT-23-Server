package org.sopt.seminar8.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar8.domain.Content;

import java.util.List;

/**
 * Created by ds on 2018-12-20.
 */

@Mapper
public interface ContentMapper {

    /**
     * 모든 컨텐츠 조회
     *
     * @return 컨텐츠 리스트
     */
    @Select("SELECT * FROM content ORDER BY contentIdx")
    List<Content> findAll();

    /**
     * 컨텐츠 저장
     *
     * @param content 컨텐츠 데이터
     */
    @Insert("INSERT INTO content(userIdx, body, createdDate) VALUES(#{content.userIdx}, #{content.body}, #{content.createdDate})")
    @Options(useGeneratedKeys = true, keyProperty = "contentReq.contentIdx")
    void save(@Param("content") final Content content);

    /**
     * 컨텐츠 삭제
     *
     * @param contentIdx 컨텐츠 고유 번호
     */
    @Delete("DELETE FROM content WHERE contentIdx = #{contentIdx}")
    void deleteByContentIdx(@Param("contentIdx") final int contentIdx);
}