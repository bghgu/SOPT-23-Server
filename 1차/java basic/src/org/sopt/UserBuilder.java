package org.sopt;

/**
 * Created by ds on 2018-09-25.
 */

public class UserBuilder {
    private int idx;
    private String name;
    private String part;
    public UserBuilder setIdx(final int idx) {
        this.idx = idx;
        return this;
    }
    public UserBuilder setName(final String name) {
        this.name = name;
        return this;
    }
    public UserBuilder setPart(final String part) {
        this.part = part;
        return this;
    }
    public User build() {
        return new User(this.idx, this.name, this.part);
    }
}
