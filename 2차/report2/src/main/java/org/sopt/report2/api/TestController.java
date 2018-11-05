package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.sopt.report2.model.User1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2018-11-01.
 */

@RestController
@RequestMapping("/test")
public class TestController {

    private final static List<User> userList = new LinkedList<>();

    User user1 = new User(1610408,"최수정","서버");
    User user2 = new User(1510408,"최뚜띠","안드로이드");
    User user3 = new User(1410408,"최수똥","iOS");
    User user4 = new User(1310408,"최냥냥","디자인");
    User user5 = new User(1210408,"최몽몽","기획");


    @GetMapping("/")
    public String getCurrentTime(){
        return "시간";
    }

    @GetMapping("/users")
    public List<User> getUserList(){
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        if(userList.isEmpty()){
            return null;
        }else {
            return userList;
        }

    }
}
