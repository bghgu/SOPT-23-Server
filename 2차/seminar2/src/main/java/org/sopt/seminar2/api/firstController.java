package org.sopt.seminar2.api;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-10-04.
 */

@RestController
public class firstController {

    @GetMapping("")
    public String hello() {
        return "hello world!";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "")
//    public String hello2() {
//        return "Nice to Meet You!";
//    }

    @GetMapping("1")
    public String hello2() {
        return "hello world!!";
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
        System.out.println(name);
        return name;
    }

}
