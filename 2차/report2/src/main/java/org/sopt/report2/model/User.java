package org.sopt.report2.model;

/**
 * Created by ds on 2018-10-12.
 */

public class User {
    //회원 고유번호
    private int user_idx;
    //회원 이름
    private String name;
    //회원 파트
    private String part;

    public User() {}

    public User(final int user_idx, final String name, final String part) {
        this.user_idx = user_idx;
        this.name = name;
        this.part = part;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(final int user_idx) {
        this.user_idx = user_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(final String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_idx=" + user_idx +
                ", name='" + name + '\'' +
                ", part='" + part + '\'' +
                '}';
    }
}
