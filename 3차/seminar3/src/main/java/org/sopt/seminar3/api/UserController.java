package org.sopt.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.LoginService;
import org.sopt.seminar3.service.UserService;
import org.sopt.seminar3.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ds on 2018-10-14.
 */

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private static final DefaultRes<User> FAIL_DEFAULT_RES
            = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);

    private final UserService userService;

    private final UserService userService2;

    /**
     * 지양하자
     */
    //@Autowired
    private final LoginService loginService;

    /**
     * 생성자가 1개일 경우 @Autowired가 생략 가능하다.
     * @param userService
     * @param userService2
     * @param loginService
     */
    public UserController(@Qualifier("UserServiceImpl") final UserService userService,
                          @Qualifier("UserServiceImpl2") final UserService userService2,
                          final LoginService loginService) {
        log.info("DI UserController");
        this.userService = userService;
        this.userService2 = userService2;
        this.loginService = loginService;
    }

    @GetMapping("")
    public ResponseEntity getAllUsers() {
        log.info("get All Users");
        try {
            loginService.login();
            return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userIdx}")
    public ResponseEntity getUser(@PathVariable final int userIdx) {
        log.info(userIdx + "");
        try {
            return new ResponseEntity<>(userService.findOneUser(userIdx), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity saveUser(@RequestBody final User user) {
        log.info(user.toString());
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userIdx}")
    public ResponseEntity updateUser(
            @PathVariable final int userIdx,
            @RequestBody final User user) {
        log.info(user.toString());
        try {
            return new ResponseEntity<>(userService.updateUser(userIdx, user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable final int userIdx) {
        log.info(userIdx + "");
        try {
            return new ResponseEntity<>(userService.deleteUser(userIdx), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
