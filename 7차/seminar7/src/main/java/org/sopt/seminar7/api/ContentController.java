package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.model.ContentReq;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.service.ContentService;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.sopt.seminar7.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.sopt.seminar7.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by ds on 2018-11-30.
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
    public ResponseEntity getAllContents(@RequestHeader(value = "Authorization", required = false) final String header) {
        try {

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contents/{contentIdx}")
    public ResponseEntity getContent(@PathVariable("contentIdx") final int contentIdx) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PostMapping("/contents")
    public ResponseEntity saveContent(ContentReq contentReq, @RequestPart("photo") final Optional<MultipartFile> photo) {
        try {
            if(photo.isPresent()) contentReq.setPhoto(photo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PutMapping("/contents/{contentIdx}/likes")
    public ResponseEntity like() {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PutMapping("/contents/{contentIdx}")
    public ResponseEntity updateContent(
            @PathVariable("contentIdx") final int contentIdx,
            ContentReq contentReq,
            @RequestPart("photo") final Optional<MultipartFile> photo) {
        try {
            if(photo.isPresent()) contentReq.setPhoto(photo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @DeleteMapping("/contents/{contentIdx}")
    public ResponseEntity deleteContent(@PathVariable("contentIdx") final int contentIdx) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
