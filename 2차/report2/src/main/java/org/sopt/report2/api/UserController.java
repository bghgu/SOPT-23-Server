package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2018-10-12.
 */

@RestController
public class UserController {

    private final static List<User> userList = new LinkedList<>();
    /**
     * 현재 시간 반환
     *
     * @return 현재 시간 문자열
     */
    @GetMapping
    public String getNowTime() {
        return new Date().toString();
    }

    /**
     * 모든 회원 리스트 조회
     *
     * @return 회원 리스트
     */
//    @GetMapping("/users")
//    public String getUserList(
//            @RequestParam(value = "name", required = false) final Optional<String> name,
//            @RequestParam(value = "part", required = false) final Optional<String> part) {
//        if (name.isPresent()) {
//            for (User u : userList) {
//                if (u.getName().equals(name.get())) return u.toString();
//            }
//            return "없습니다";
//        }
//        if (part.isPresent()) {
//            for (User u : userList) {
//                if (u.getPart().equals(part.get())) return u.toString();
//            }
//            return "없습니다";
//        } else {
//            if(userList.isEmpty()) return "리스트가 비었습니다.";
//            else {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (User u : userList) {
//                    stringBuilder.append(u.toString()).append("\n");
//                }
//                return stringBuilder.toString();
//            }
//        }
//    }

    @GetMapping("/users")
    public String getUserList(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "part", required = false) final String part) {
        if (name != null) {
            System.out.println(name);
            for (User u : userList) {
                if (u.getName().equals(name)) return u.toString();
            }
            return "없습니다";
        }
        if (part != null) {
            System.out.println(part);
            for (User u : userList) {
                if (u.getPart().equals(part)) return u.toString();
            }
            return "없습니다";
        } else {
            if(userList.isEmpty()) return "리스트가 비었습니다.";
            else {
                StringBuilder stringBuilder = new StringBuilder();
                for (User u : userList) {
                    stringBuilder.append(u.toString()).append("\n");
                }
                return stringBuilder.toString();
            }
        }
    }

    @GetMapping("/users/{userIdx}")
    public String getUser(@PathVariable(value = "userIdx") final int userIdx) {
        for (User u : userList) {
            if (u.getUser_idx() == userIdx) return u.toString();
        }
        return "없습니다";
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody final User user) {
        userList.add(user);
        return "Success Save user";
    }

    @PutMapping("/users/{userIdx}")
    public String updateUser(
            @PathVariable(value = "userIdx") final int userIdx,
            @RequestBody final User user) {
        for (User u : userList) {
            if (u.getUser_idx() == userIdx) {
                userList.remove(u);
                userList.add(user);
                return "Success Update User";
            }
        }
        return "Fail Update User";
    }

    @DeleteMapping("/users/{userIdx}")
    public String deleteUser(@PathVariable(value = "userIdx") final int userIdx) {
        for (User u : userList) {
            if (u.getUser_idx() == userIdx) {
                userList.remove(u);
                return "Success Delete User";
            }
        }
        return "Fail Delete User";
    }

}
