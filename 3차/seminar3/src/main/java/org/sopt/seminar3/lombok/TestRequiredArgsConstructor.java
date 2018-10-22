package org.sopt.seminar3.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by ds on 2018-10-22.
 */

/**
 * @RequiredArgsConstructor
 * @NonNull이나 Final 키워드 붙은 필드에 대해 생성자 자동 생성
 */

@RequiredArgsConstructor
public class TestRequiredArgsConstructor {
    private int userIdx;
    @NonNull
    private String name;
    private final String email;

    //@NonNull, final 키워드가 붙은 필드의 생성자 자동 생성
//    public TestRequiredArgsConstructor(
//            final String name,
//            final String email) {
//        this.name = name;
//        this.email = email;
//    }
}
