package org.sopt.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-10-22.
 */

//로그
@Slf4j
@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {

    //@NonNull
    private final UserService userService;

    /**
     * @RequiredArgsConstructor가 @NonNull이 붙은 필드의 생성자 자동 생성
     */

    /**
     * 생성자가 1개일 경우 @Autowired 생략 가능
     * @param userService user 서비스
     */
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getAllUsers() {
        log.info("get All Users");
        User user = new User(1, "배다슬", "서버");
        DefaultRes<User> defaultRes = new DefaultRes<User>(HttpStatus.OK.value(), "회원 정보", user);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }


}
