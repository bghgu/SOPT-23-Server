package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.dto.Content;
import org.sopt.seminar7.dto.User;
import org.sopt.seminar7.model.ContentReq;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.model.Pagination;
import org.sopt.seminar7.service.ContentService;
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
public class ContentController {

    private static final DefaultRes UNAUTHORIZED_RES = new DefaultRes(StatusCode.UNAUTHORIZED, ResponseMessage.UNAUTHORIZED);

    private final ContentService contentService;
    private final JwtService jwtService;

    public ContentController(final ContentService contentService, final JwtService jwtService) {
        this.contentService = contentService;
        this.jwtService = jwtService;
    }

    /**
     * 모든 컨텐츠 조회
     *
     * @param header     jwt token
     * @param pagination 페이지네이션
     * @return ResponseEntity
     */
    @GetMapping("/contents")
    public ResponseEntity getAllContents(
            @RequestHeader(value = "Authorization", required = false) final String header,
            final Pagination pagination) {
        try {
            final int userIdx = jwtService.decode(header).getUser_idx();

            DefaultRes<List<Content>> defaultRes = contentService.findAll(pagination);

            for (Content content : defaultRes.getData()) {
                content.setAuth(userIdx == content.getUserIdx());
                content.setLike(contentService.checkLike(userIdx, content.getContentIdx()));
            }

            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 조회
     *
     * @param header     jwt token
     * @param contentIdx 컨텐츠 고유 번호
     * @return ResponseEntity
     */
    @GetMapping("/contents/{contentIdx}")
    public ResponseEntity getContent(
            @RequestHeader(value = "Authorization", required = false) final String header,
            @PathVariable("contentIdx") final int contentIdx) {
        try {
            final int userIdx = jwtService.decode(header).getUser_idx();

            DefaultRes<Content> defaultRes = contentService.findByContentIdx(contentIdx);

            defaultRes.getData().setAuth(userIdx == defaultRes.getData().getUserIdx());
            defaultRes.getData().setLike(contentService.checkLike(userIdx, contentIdx));

            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 작성
     *
     * @param contentReq 컨텐츠 데이터
     * @return ResponseEntity
     */
    @Auth
    @PostMapping("/contents")
    public ResponseEntity saveContent(
            @RequestHeader(value = "Authorization") final String header,
            ContentReq contentReq) {
        try {
            contentReq.setUserIdx(jwtService.decode(header).getUser_idx());
            return new ResponseEntity<>(contentService.save(contentReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 좋아요
     *
     * @return
     */
    @Auth
    @PutMapping("/contents/{contentIdx}/likes")
    public ResponseEntity like(
            @RequestHeader(value = "Authorization") final String header,
            @PathVariable("contentIdx") final int contentIdx) {
        try {
            final int userIdx = jwtService.decode(header).getUser_idx();
            return new ResponseEntity<>(contentService.likes(userIdx, contentIdx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 수정
     *
     * @param header     jwt token
     * @param contentIdx 컨텐츠 고유 번호
     * @param contentReq 컨텐츠 데이터
     * @return
     */
    @Auth
    @PutMapping("/contents/{contentIdx}")
    public ResponseEntity updateContent(
            @RequestHeader(value = "Authorization") final String header,
            @PathVariable("contentIdx") final int contentIdx,
            ContentReq contentReq) {
        try {
            contentReq.setContentIdx(contentIdx);
            if (contentService.checkAuth(jwtService.decode(header).getUser_idx(), contentIdx))
                return new ResponseEntity<>(contentService.update(contentReq), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 삭제
     *
     * @param header     jwt token
     * @param contentIdx 컨텐츠 고유 번호
     * @return ResponseEntity
     */
    @Auth
    @DeleteMapping("/contents/{contentIdx}")
    public ResponseEntity deleteContent(
            @RequestHeader(value = "Authorization") final String header,
            @PathVariable("contentIdx") final int contentIdx) {
        try {
            if (contentService.checkAuth(jwtService.decode(header).getUser_idx(), contentIdx))
                return new ResponseEntity<>(contentService.deleteByContentIdx(contentIdx), HttpStatus.OK);
            return new ResponseEntity<>(UNAUTHORIZED_RES, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
