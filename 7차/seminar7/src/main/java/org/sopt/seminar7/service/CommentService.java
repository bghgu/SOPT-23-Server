package org.sopt.seminar7.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.Comment;
import org.sopt.seminar7.dto.CommentLike;
import org.sopt.seminar7.mapper.CommentLikeMapper;
import org.sopt.seminar7.mapper.CommentMapper;
import org.sopt.seminar7.model.CommentReq;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by ds on 2018-12-05.
 */

@Slf4j
@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentLikeMapper commentLikeMapper;
    private final ContentService contentService;

    public CommentService(final CommentMapper commentMapper,
                          final CommentLikeMapper commentLikeMapper,
                          final ContentService contentService) {
        this.commentMapper = commentMapper;
        this.commentLikeMapper = commentLikeMapper;
        this.contentService = contentService;
    }

    /**
     * 글에 작성된 댓글 조회
     *
     * @param contentIdx 게시글 고유 번호
     * @return 댓글 리스트
     */
    public DefaultRes<List<Comment>> findByContentIdx(final int contentIdx) {
        List<Comment> commentList = commentMapper.findAllByContentIdx(contentIdx);
        if (commentList.isEmpty()) return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_CONTENT);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_ALL_COMMENTS, commentList);
    }

    /**
     * 댓글 상세 조회
     *
     * @param commentIdx 댓글 고유 번호
     * @return 댓글
     */
    public Comment findByCommentIdx(final int commentIdx) {
        final Comment comment = commentMapper.findByCommentIdx(commentIdx);
        if (comment == null) return new Comment();
        //if (comment.getU_id() == auth) comment.setAuth(true);
        CommentLike commentLike;
        return comment;
    }

    /**
     * 댓글 작성
     *
     * @param commentReq 댓글 데이터
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes save(final CommentReq commentReq) {
        if (contentService.findByContentIdx(commentReq.getContentIdx()).getData() == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_CONTENT);
        try {
            log.info(commentReq.toString());

            commentMapper.save(commentReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATE_COMMENT);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 댓글 좋아요
     *
     * @param userIdx 회원 고유 번호
     * @param commentIdx 댓글 고유 번호
     * @return
     */
    @Transactional
    public DefaultRes likes(final int userIdx, final int commentIdx) {
        Comment comment = commentMapper.findByCommentIdx(commentIdx);
        if (comment == null) return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_CONTENT);

        CommentLike commentLike = commentLikeMapper.findByUserIdxAndCommentIdx(userIdx, commentIdx);

        try {
            if (commentLike == null) {
                commentMapper.like(commentIdx, comment.getLikeCount() + 1);
                commentLikeMapper.save(userIdx, commentIdx);
            } else {
                commentMapper.like(commentIdx, comment.getLikeCount() - 1);
                commentLikeMapper.deleteByUserIdxAndCommentIdx(userIdx, commentIdx);
            }

            comment = findByCommentIdx(commentIdx);
            comment.setAuth(checkAuth(userIdx, commentIdx));
            comment.setLike(checkLike(userIdx, commentIdx));

            return DefaultRes.res(StatusCode.OK, ResponseMessage.LIKE_COMMENT, comment);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 댓글 수정
     *
     * @param commentReq 댓글 내용
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes<Comment> update(final CommentReq commentReq) {
        Comment temp = commentMapper.findByCommentIdx(commentReq.getCommentIdx());
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_COMMENT);

        try {
            commentMapper.updateByCommentIdx(commentReq);
            temp = commentMapper.findByCommentIdx(commentReq.getCommentIdx());
            temp.setAuth(true);
            return DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_COMMENT, temp);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 댓글 삭제
     *
     * @param commentIdx 댓글 고유 번호
     * @return DefaultRes
     */
    @Transactional
    public DefaultRes deleteByCommentIdx(final int commentIdx) {
        final Comment comment = commentMapper.findByCommentIdx(commentIdx);
        if (comment == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_COMMENT);

        try {
            commentMapper.deleteByCommentIdx(commentIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_COMMENT);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 댓글 권한 확인
     *
     * @param userIdx    사용자 고유 번호
     * @param commentIdx 댓글 고유 번호
     * @return boolean
     */
    public boolean checkAuth(final int userIdx, final int commentIdx) {
        return userIdx == findByCommentIdx(commentIdx).getUserIdx();
    }

    public boolean checkLike(final int userIdx, final int commentIdx) {
        return commentLikeMapper.findByUserIdxAndCommentIdx(userIdx, commentIdx) != null;
    }
}
