package org.sopt.seminar.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-09-24.
 */

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }
}


