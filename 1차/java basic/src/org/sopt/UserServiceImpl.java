package org.sopt;

/**
 * Created by ds on 2018-09-25.
 */

public class UserServiceImpl implements UserInterface {

    //필수 구현 메소드
    @Override
    public void getInfo() {

    }

    //필수 구현 메소드
    @Override
    public String getDept() {
        return null;
    }

    //선택 구현 메소드
    @Override
    public void setState(boolean state) {
        //재정의해서 사용할 수 있다.
    }
}
