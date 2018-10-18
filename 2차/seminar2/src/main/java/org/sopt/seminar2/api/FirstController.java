package org.sopt.seminar2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-10-12.
 */

@RestController
public class FirstController {
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

    @GetMapping("get1/배다슬")
    public String get2() {
        return "배다슬";
    }

    @GetMapping("/name/{name}")
    public String asdasd(@PathVariable(value = "name", required = false) final String name) {
        return name;
    }

    @GetMapping("/part")
    public String getPart(@RequestParam(value = "part", defaultValue = "솝트") final String part) {
        return part;
    }

    @GetMapping("/info")
    public String getPart2(
            @RequestParam(value = "name", defaultValue = "류지훈") final String name,
            @RequestParam(value = "type", defaultValue = "회장") final String type) {
        System.out.println(name + "이고 " + type + "입니다.");
        return name + "이고 " + type + "입니다.";
    }

    @GetMapping("/num")
    public int number(@RequestParam final int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }
}