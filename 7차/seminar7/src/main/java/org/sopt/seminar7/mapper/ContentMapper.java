package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar7.dto.Content;
import org.sopt.seminar7.model.ContentReq;
import org.sopt.seminar7.model.Pagination;

import java.util.List;

/**
 * Created by ds on 2018-12-04.
 */

@Mapper
public interface ContentMapper {

    /**
     * 모든 컨텐츠 조회
     *
     * @param pagination 페이지네이션 객체
     * @return 컨텐츠 리스트
     */
    @Select("SELECT * FROM content ORDER BY contentIdx DESC LIMIT #{pagination.limit} OFFSET #{pagination.offset}")
    List<Content> findAll(@Param("pagination") final Pagination pagination);

    /**
     * 컨텐츠 조회
     *
     * @param contentIdx 컨텐츠 고유 번호
     * @return 컨텐츠
     */
    @Select("SELECT * FROM content WHERE contentIdx = #{contentIdx}")
    Content findByContentIdx(@Param("contentIdx") final int contentIdx);

    /**
     * 컨텐츠 저장
     *
     * @param contentReq 컨텐츠 데이터
     */
    @Insert("INSERT INTO content(userIdx, body, createdDate) VALUES(#{contentReq.userIdx}, #{contentReq.body}, #{contentReq.createdDate})")
    @Options(useGeneratedKeys = true, keyProperty = "contentReq.contentIdx")
    void save(@Param("contentReq") final ContentReq contentReq);

    /**
     * 좋아요 카운트
     *
     * @param contentIdx 컨텐츠 고유 번호
     * @param likeCount  좋아요 카운트
     */
    @Update("UPDATE content SET likeCount = #{likeCount} WHERE contentIdx = #{contentIdx}")
    void like(@Param("contentIdx") final int contentIdx, @Param("likeCount") final int likeCount);

    /**
     * 컨텐츠 수정
     *
     * @param contentReq 컨텐츠 데이터
     * @param contentIdx 컨텐츠 고유 번호
     */
    @Update("UPDATE content SET body = #{contentReq.body}, createdDate = #{contentReq.createdDate} WHERE contentIdx = #{contentIdx}")
    void updateByContentIdx(@Param("contentReq") final ContentReq contentReq, @Param("contentIdx") final int contentIdx);

    /**
     * 컨텐츠 삭제
     *
     * @param contentIdx 컨텐츠 고유 번호
     */
    @Delete("DELETE FROM content WHERE contentIdx = #{contentIdx}")
    void deleteByContentIdx(@Param("contentIdx") final int contentIdx);
}
