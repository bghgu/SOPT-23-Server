package org.sopt;

/**
 * Created by ds on 2018-09-25.
 */

public class Student extends Person {

    private String deaprtment;

    public Student(final String name, final String deaprtment) {
        //부모 클래스의 생성자 사용
        super(name);
        this.deaprtment = deaprtment;
    }

    public String getDeaprtment() {
        return deaprtment;
    }

    public void setDeaprtment(String deaprtment) {
        this.deaprtment = deaprtment;
    }
}
