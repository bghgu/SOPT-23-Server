package org.sopt.seminar8.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.domain.Content;
import org.sopt.seminar8.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.seminar8.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-12-19.
 */

@Slf4j
@RestController
public class ContentController {

    private final ContentService contentService;

    public ContentController(final ContentService contentService) {
        this.contentService = contentService;
    }

    /**
     * 모든 컨텐츠 조회
     * @return
     */
    @GetMapping("/contents")
    public ResponseEntity getAllContents() {
        try {
            return new ResponseEntity<>(contentService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 저장
     * @return
     */
    @PostMapping("/contents")
    public ResponseEntity saveContent(final Content content) {
        try {
            return new ResponseEntity<>(contentService.save(content), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 컨텐츠 삭제
     * @param contentIdx
     * @return
     */
    @DeleteMapping("/contents/{contentIdx}")
    public ResponseEntity deleteContent(@PathVariable("contentIdx") final int contentIdx) {
        try {
            return new ResponseEntity<>(contentService.deleteByContentIdx(contentIdx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
