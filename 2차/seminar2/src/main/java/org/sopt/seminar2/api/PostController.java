package org.sopt.seminar2.api;

import org.sopt.seminar2.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-10-12.
 */

@RestController
@RequestMapping(value = "post", method = {})
public class PostController {

    @PostMapping("")
    public String postUser(@RequestBody final User user) {
        return user.getName();
    }
}
