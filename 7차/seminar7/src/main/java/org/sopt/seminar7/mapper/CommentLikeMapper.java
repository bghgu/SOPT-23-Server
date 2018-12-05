package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar7.dto.CommentLike;

/**
 * Created by ds on 2018-12-04.
 */

@Mapper
public interface CommentLikeMapper {

    /**
     * 좋아요 조회
     *
     * @param commentIdx 댓글 고유 번호
     * @param userIdx    회원 고유 번호
     * @return 좋아요 객체
     */
    @Select("SELECT * FROM commentLike WHERE commentIdx = #{commentIdx} AND userIdx = #{userIdx}")
    CommentLike findByUserIdxAndCommentIdx(@Param("commentIdx") final int commentIdx, @Param("userIdx") final int userIdx);

    /**
     * 좋아요
     *
     * @param commentIdx 댓글 고유 번호
     * @param userIdx    회원 고유 번호
     */
    @Insert("INSERT INTO commentLike(commentIdx, userIdx) VALUES(#{commentIdx}, #{userIdx})")
    void save(@Param("commentIdx") final int commentIdx, @Param("userIdx") final int userIdx);

    /**
     * 좋아요 취소
     *
     * @param commentIdx 댓글 고유 번호
     * @param userIdx    회원 고유 번호
     */
    @Delete("DELETE FROM commentLike WHERE commentIdx = #{commentIdx} AND userIdx = #{userIdx}")
    void deleteByUserIdxAndCommentIdx(@Param("commentIdx") final int commentIdx, @Param("userIdx") final int userIdx);
}
