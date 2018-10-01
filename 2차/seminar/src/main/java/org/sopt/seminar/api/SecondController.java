package org.sopt.seminar.api;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-10-01.
 */

@RestController
public class SecondController {

    @GetMapping("")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "1")
    public String hello2() {
        return "Nice to Meet You!";
    }

    @PostMapping("")
    public void post() {

    }

    @RequestMapping(method = RequestMethod.POST, value = "1")
    public String post2() {
        return "Nice to Meet You!";
    }

    @PutMapping("")
    public void put() {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "1")
    public String put2() {
        return "Nice to Meet You!";
    }

    @DeleteMapping("")
    public void delete() {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "1")
    public String delete2() {
        return "Nice to Meet You!";
    }

}
