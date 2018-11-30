package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-11-30.
 */

@Slf4j
@RestController
public class ContentController {

    @GetMapping("/contents")
    public ResponseEntity getAllContents() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/contents/{contentIdx}")
    public ResponseEntity getContent(@PathVariable("contentIdx") final int contentIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Auth
    @PostMapping("/contents")
    public ResponseEntity saveContent() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Auth
    @PutMapping("/contents/{contentIdx}")
    public ResponseEntity updateContent(@PathVariable("contentIdx") final int contentIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Auth
    @DeleteMapping("/contents/{contentIdx}")
    public ResponseEntity deleteContent(@PathVariable("contentIdx") final int contentIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
