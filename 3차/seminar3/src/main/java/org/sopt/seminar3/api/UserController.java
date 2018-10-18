package org.sopt.seminar3.api;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by ds on 2018-10-14.
 */

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {

    @GetMapping("")
    public String getUser() {
        return "user";
    }

    @GetMapping("all/{name}")
    public String allUser(@PathVariable(value = "name", required = false) final Optional<String> name) {
        System.out.println(name);
        return "all User";
    }

    @PostMapping("")
    public String saveUser() {
        return "save User";
    }

    @PostMapping("/test")
    public String saveUser1() {
        return "save User";
    }
}
