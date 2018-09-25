package org.sopt;

import java.sql.Timestamp;

/**
 * Created by ds on 2018-09-25.
 */
public class User2Builder {
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

    public User2Builder setUserIdx(final Integer userIdx) {
        this.userIdx = userIdx;
        return this;
    }

    public User2Builder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public User2Builder setPassword(final String password) {
        this.password = password;
        return this;
    }

    public User2Builder setName(final String name) {
        this.name = name;
        return this;
    }

    public User2Builder setPoint(final Integer point) {
        this.point = point;
        return this;
    }

    public User2Builder setSignupAt(final Timestamp signupAt) {
        this.signupAt = signupAt;
        return this;
    }

    public User2Builder setProfileUrl(final String profileUrl) {
        this.profileUrl = profileUrl;
        return this;
    }

    public User2Builder setBackgroundUrl(final String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
        return this;
    }

    public User2Builder setPosition(final String position) {
        this.position = position;
        return this;
    }

    public User2Builder setIntroduce(final String introduce) {
        this.introduce = introduce;
        return this;
    }

    public User2Builder setPortfolioUrl(final String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
        return this;
    }

    public User2Builder setAim(final String aim) {
        this.aim = aim;
        return this;
    }

    public User2Builder setDepartment(final String department) {
        this.department = department;
        return this;
    }

    public User2Builder setArea(final String area) {
        this.area = area;
        return this;
    }

    public User2Builder setFcmToken(final String fcmToken) {
        this.fcmToken = fcmToken;
        return this;
    }

    public User2 build() {
        return new User2(
                this.userIdx,
                this.email,
                this.password,
                this.name,
                this.point,
                this.signupAt,
                this.profileUrl,
                this.backgroundUrl,
                this.position,
                this.introduce,
                this.portfolioUrl,
                this.aim,
                this.department,
                this.area,
                this.fcmToken);
    }
}
