package org.sopt.seminar.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-11-27.
 */

@RestController
public class Controller {

    @GetMapping("/redis")
    public String redisTest() {
        return "redis";
    }

    @GetMapping("/mongodb")
    public String mongoDBTest() {
        return "mongoDB";
    }
}
