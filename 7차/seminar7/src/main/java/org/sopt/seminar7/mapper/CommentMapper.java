package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar7.dto.Comment;
import org.sopt.seminar7.model.CommentReq;

import java.util.List;

/**
 * Created by ds on 2018-12-04.
 */

@Mapper
public interface CommentMapper {

    /**
     * 해당 컨텐츠의 모든 댓글 조회
     *
     * @param contentIdx 컨텐츠 고유 번호
     * @return comment List
     */
    @Select("SELECT * FROM comment WHERE contentIdx = #{contentIdx}")
    List<Comment> findAllByContentIdx(@Param("contentIdx") final int contentIdx);

    /**
     * 댓글 조회
     *
     * @param commentIdx 댓글 고유 번호
     * @return comment
     */
    @Select("SELECT * FROM comment WHERE commentIdx = #{commentIdx}")
    Comment findByCommentIdx(@Param("commentIdx") final int commentIdx);

    /**
     * 댓글 작성
     *
     * @param commentReq 댓글 데이터
     */
    @Insert("INSERT INTO comment(userIdx, body, createdDate, contentIdx) VALUES(commentReq.userIdx, commentReq.body, commentReq.createdDate, commentReq.contentIdx)")
    @Options(useGeneratedKeys = true, keyProperty = "commentReq.commentIdx")
    void save(@Param("commentReq") final CommentReq commentReq);

    /**
     * 좋아요 카운트
     *
     * @param commentIdx 댓글 고유 번호
     * @param likeCount  좋아요 카운트
     */
    @Update("UPDATE comment SET likeCount = #{likeCount} where commentIdx = #{commentIdx}")
    void like(@Param("commentIdx") final int commentIdx, @Param("likeCount") final int likeCount);

    /**
     * 댓글 수정
     *
     * @param commentReq 댓글
     */
    @Update("UPDATE comment SET body = #{commentReq.body}, createdDate = #{commentReq.createdDate} WHERE commentIdx = #{commentReq.commentIdx}")
    void updateByCommentIdx(@Param("commentReq") final CommentReq commentReq);

    /**
     * 댓글 삭제
     *
     * @param commentIdx 댓글 고유 번호
     */
    @Delete("DELETE FROM comment WHERE c_id = #{c_id}")
    void deleteByCommentIdx(@Param("c_id") final int commentIdx);
}
