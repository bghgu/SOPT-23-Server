package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.Comment;
import org.sopt.seminar7.model.CommentReq;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.service.CommentService;
import org.sopt.seminar7.service.JwtService;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.sopt.seminar7.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sopt.seminar7.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-11-30.
 */

@Slf4j
@RestController
public class CommentController {

    private static final DefaultRes UNAUTHORIZED_RES = new DefaultRes(StatusCode.UNAUTHORIZED, ResponseMessage.UNAUTHORIZED);

    private final CommentService commentService;

    private final JwtService jwtService;

    public CommentController(final CommentService commentService, final JwtService jwtService) {
        this.commentService = commentService;
        this.jwtService = jwtService;
    }

    /**
     * 해당 컨텐츠의 모든 댓글 조회
     *
     * @param header     jwt token
     * @param contentIdx 컨텐츠 고유 번호
     * @return ResponseEntity
     */
    @GetMapping("/contents/{contentIdx}/comments")
    public ResponseEntity getAllComments(
            @RequestHeader(value = "Authorization", required = false) final String header,
            @PathVariable final int contentIdx) {
        try {
            final int userIdx = jwtService.decode(header).getUser_idx();
            DefaultRes<List<Comment>> defaultRes = commentService.findByContentIdx(contentIdx);
            if(defaultRes.getData() != null) {
                for (Comment c : defaultRes.getData()) {
                    c.setAuth(c.getUserIdx() == userIdx);
                    c.setLike(commentService.checkLike(userIdx, c.getUserIdx()));
                }
            }
            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 댓글 작성
     *
     * @param jwt        jwt token
     * @param contentIdx 컨텐츠 고유 번호
     * @param commentReq 댓글 데이터
     * @return ResponseEntity
     */
    @Auth
    @PostMapping("/contents/{contentIdx}/comments")
    public ResponseEntity writeComments(
            @RequestHeader("Authorization") final String jwt,
            @PathVariable final int contentIdx,
            @RequestBody CommentReq commentReq) {
        try {
            commentReq.setUserIdx(jwtService.decode(jwt).getUser_idx());
            commentReq.setContentIdx(contentIdx);
            return new ResponseEntity<>(commentService.save(commentReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 댓글 좋아요
     *
     * @param jwt        토큰
     * @param commentIdx 댓글 고유 번호
     * @return ResponseEntity
     */
    @Auth
    @PostMapping("/comments/{commentIdx}/likes")
    public ResponseEntity commentLikes(
            @RequestHeader("Authorization") final String jwt,
            @PathVariable final int commentIdx) {
        try {
            return new ResponseEntity<>(commentService.likes(jwtService.decode(jwt).getUser_idx(), commentIdx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 댓글 수정
     *
     * @param jwt        jwt token
     * @param commentIdx 댓글 고유 번호
     * @param commentReq 댓글 데이터
     * @return ResponseEntity
     */
    @Auth
    @PutMapping("/comments/{commentIdx}")
    public ResponseEntity updateComment(
            @RequestHeader("Authorization") final String jwt,
            @PathVariable final int commentIdx,
            @RequestBody final CommentReq commentReq) {
        try {
            final int userIdx = jwtService.decode(jwt).getUser_idx();
            commentReq.setCommentIdx(commentIdx);
            if (commentService.checkAuth(userIdx, commentIdx))
                return new ResponseEntity<>(commentService.update(commentReq), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 댓글 삭제
     *
     * @param commentIdx 댓글 고유 번호
     * @return ResponseEntity
     */
    @Auth
    @DeleteMapping("/comments/{commentIdx}")
    public ResponseEntity deleteComment(
            @RequestHeader("Authorization") final String jwt,
            @PathVariable final int commentIdx) {
        try {
            final int userIdx = jwtService.decode(jwt).getUser_idx();
            if (commentService.checkAuth(userIdx, commentIdx))
                return new ResponseEntity<>(commentService.deleteByCommentIdx(commentIdx), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
