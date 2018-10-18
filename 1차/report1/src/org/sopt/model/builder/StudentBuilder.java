package org.sopt.model.builder;

import org.sopt.model.Student;

/**
 * Created by ds on 2018-09-28.
 */
public class StudentBuilder {
    //학번
    private int studentIdx;
    //이름
    private String studentName;
    //학년
    private int studentGrade;
    //이메일
    private String email;
    //주소
    private String address;
    //나이
    private int age;
    //현재 상태(휴학, 재학, 군휴학, 취업계)
    private String current;

    public StudentBuilder setStudentIdx(final int studentIdx) {
        this.studentIdx = studentIdx;
        return this;
    }

    public StudentBuilder setStudentName(final String studentName) {
        this.studentName = studentName;
        return this;
    }

    public StudentBuilder setStudentGrade(final int studentGrade) {
        this.studentGrade = studentGrade;
        return this;
    }

    public StudentBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setAddress(final String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setAge(final int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setCurrent(final String current) {
        this.current = current;
        return this;
    }

    public Student build() {
        return new Student(this.studentIdx, this.studentName, this.studentGrade, this.email, this.address, this.age, this.current);
    }
}
