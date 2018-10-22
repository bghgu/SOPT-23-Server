package org.sopt.seminar3.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * Created by ds on 2018-10-22.
 */

/**
 * null 체크
 * NullPointerException
 * Runtime시에 Null Check
 * @NonNull
 */

@AllArgsConstructor
public class TestNonNull {
    private int userIdx;
    @NonNull
    private String name;
    private String email;

    public TestNonNull() {
        this.name = null;
    }
}
