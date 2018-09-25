package org.sopt;

/**
 * Created by ds on 2018-09-25.
 */

public interface UserInterface {
    //상수 필드
    //public static final 생략이 가능하다.
    public static final String DEPT = "소프트웨어공학과";
    int DEPTNO = 320;

    //추상 메소드
    //public abstract 생략이 가능하다.
    public abstract void getInfo();

    String getDept();

    //디폴트 메소드
    //메소드 내용까지 구현이 가능하다.
    //해당 인터페이스 구현시 디폴트 메소드를 override해서 사용할 수 있다.
    //public 생략이 가능하다.
    public default void setState(final boolean state) {
        if (state) {
            System.out.println("휴학중");
        } else {
            System.out.println("재학중");
        }
    }

    //정적 메소드
    //public 생략이 가능하다.
    public static void world() {
        System.out.println("World!");
    }
}
