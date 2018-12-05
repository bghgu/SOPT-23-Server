package org.sopt.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar7.model.DefaultRes;
import org.sopt.seminar7.service.CommentService;
import org.sopt.seminar7.utils.ResponseMessage;
import org.sopt.seminar7.utils.StatusCode;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-11-30.
 */

@Slf4j
@RestController
public class CommentController {

    private static final DefaultRes UNAUTHORIZED_RES = new DefaultRes(StatusCode.UNAUTHORIZED, ResponseMessage.UNAUTHORIZED);

    private final CommentService commentService;

    public CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

    
}
