package org.sopt.seminar3.lombok;

/**
 * Created by ds on 2018-10-22.
 */

public class Main {

    public static void main(String... args) {
        //immutable 객체
        TestValue testValue = new TestValue(0, "배다슬", "bghgu@naver.com");
        //@Wither
        //값을 변경한 새로운 객체를 만들어 준다.
        TestValue testValue1 = testValue.withUserIdx(1);
    }
}
