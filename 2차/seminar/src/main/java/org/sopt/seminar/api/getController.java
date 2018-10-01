package org.sopt.seminar.api;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-10-01.
 */

@RestController
@RequestMapping("get")
public class getController {

    @GetMapping("")
    public String get() {
        return "get";
    }

    @GetMapping("/get1")
    public String get1() {
        return "1";
    }

    @GetMapping("/get1/배다슬")
    public String get2() {
        return "배다슬";
    }

    @GetMapping("/name/{name}")
    public String getName(@PathVariable final String name) {
        return name;
    }

    @GetMapping("/age/{age}")
    public int getAge(@PathVariable final int age) {
        return age;
    }

    @GetMapping("query")
    public String query(
            @RequestParam(value = "school") final String school,
            @RequestParam(value = "dept", required = false, defaultValue = "기본값") final String dept) {
        return school + " " + dept;
    }
}
