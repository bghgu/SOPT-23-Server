package org.sopt.seminar8.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.service.ContentService;
import org.sopt.seminar8.model.DefaultRes;
import org.sopt.seminar8.utils.ResponseMessage;
import org.sopt.seminar8.utils.StatusCode;
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

    private static final DefaultRes UNAUTHORIZED_RES = new DefaultRes(StatusCode.UNAUTHORIZED, ResponseMessage.UNAUTHORIZED);

    private final ContentService contentService;

    public ContentController(final ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/contents")
    public ResponseEntity getAllContents() {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contents")
    public ResponseEntity saveContent() {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/contents/{contentIdx}")
    public ResponseEntity deleteContent(@PathVariable("contentIdx") final int contentIdx) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
