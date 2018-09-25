package org.sopt;

import java.sql.Timestamp;

/**
 * Created by ds on 2018-09-25.
 */

public class User2 {
    private Integer userIdx;
    private String email;
    private String password;
    private String name;
    private Integer point;
    private Timestamp signupAt;
    private String profileUrl;
    private String backgroundUrl;
    private String position;
    private String introduce;
    private String portfolioUrl;
    private String aim;
    private String department;
    private String area;
    private String fcmToken;
    public User2(
            final Integer userIdx,
            final String email,
            final String password,
            final String name,
            final Integer point,
            final Timestamp signupAt,
            final String profileUrl,
            final String backgroundUrl,
            final String position,
            final String introduce,
            final String portfolioUrl,
            final String aim,
            final String department,
            final String area,
            final String fcmToken) {
        this.userIdx = userIdx;
        this.email = email;
        this.password = password;
        this.name = name;
        this.point = point;
        this.signupAt = signupAt;
        this.profileUrl = profileUrl;
        this.backgroundUrl = backgroundUrl;
        this.position = position;
        this.introduce = introduce;
        this.portfolioUrl = portfolioUrl;
        this.aim = aim;
        this.department = department;
        this.area = area;
        this.fcmToken = fcmToken;
    }
}