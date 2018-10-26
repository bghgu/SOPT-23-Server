//package org.sopt.seminar3.api;
//
//import lombok.extern.slf4j.Slf4j;
//import org.sopt.seminar3.model.DefaultRes;
//import org.sopt.seminar3.model.User;
//import org.sopt.seminar3.lombok.LoginService;
//import org.sopt.seminar3.service.UserService;
//import org.sopt.seminar3.utils.ResponseMessage;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by ds on 2018-10-14.
// */
//
////로그
//@Slf4j
//@RestController
//@RequestMapping("")
//public class TempController {
//
//    private static final DefaultRes<User> FAIL_DEFAULT_RES
//            = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);
//
//    private final UserService userService;
//    private final UserService userService2;
//    private final LoginService loginService;
//
//    public TempController(@Qualifier("UserServiceImpl") final UserService userService,
//                          @Qualifier("UserServiceImpl2") final UserService userService2,
//                          final LoginService loginService) {
//        this.userService = userService;
//        this.userService2 = userService2;
//        this.loginService = loginService;
//    }
//
//
//    @GetMapping("")
//    public ResponseEntity getAllUsers() {
//        log.info("get All Users");
//        try {
//            loginService.login();
//            userService2.deleteByUserIdx(1);
//            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{userIdx}")
//    public ResponseEntity getUser(@PathVariable final int userIdx) {
//        log.info(userIdx + "");
//        try {
//            return new ResponseEntity<>(userService.findByUserIdx(userIdx), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("")
//    public ResponseEntity saveUser(@RequestBody final User user) {
//        log.info(user.toString());
//        try {
//            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{userIdx}")
//    public ResponseEntity updateUser(
//            @PathVariable final int userIdx,
//            @RequestBody final User user) {
//        log.info(user.toString());
//        try {
//            return new ResponseEntity<>(userService.update(userIdx, user), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/{userIdx}")
//    public ResponseEntity deleteUser(@PathVariable final int userIdx) {
//        log.info(userIdx + "");
//        try {
//            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//}
