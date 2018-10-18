package org.sopt.model;

/**
 * Created by ds on 2018-09-28.
 */
public class Student extends Department{
    //학번
    private int studentIdx;
    //이름
    private String studentName;
    //학년
    private int studentGrade;
    //학과

    //이메일
    private String email;
    //주소
    private String address;
    //나이
    private int age;
    //현재 상태(휴학, 재학, 군휴학, 취업계)
    private String current;

    public Student(){}

    public Student(final int studentIdx, final String studentName, final int studentGrade, final String email, final String address, final int age, final String current) {
        super();
        this.studentIdx = studentIdx;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.email = email;
        this.address = address;
        this.age = age;
        this.current = current;
    }

    public Student(final int universityIdx, final String universityName, final String universityPhone, final String universityAddress, final int departmentIdx, final String departmentName, final String departmentPhone, final String departmentType, final int studentIdx, final String studentName, final int studentGrade, final String email, final String address, final int age, final String current) {
        super(universityIdx, universityName, universityPhone, universityAddress, departmentIdx, departmentName, departmentPhone, departmentType);
        this.studentIdx = studentIdx;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.email = email;
        this.address = address;
        this.age = age;
        this.current = current;
    }

    public int getStudentIdx() {
        return studentIdx;
    }

    public void setStudentIdx(final int studentIdx) {
        this.studentIdx = studentIdx;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(final String studentName) {
        this.studentName = studentName;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(final int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(final String current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentIdx=" + studentIdx +
                ", studentName='" + studentName + '\'' +
                ", studentGrade=" + studentGrade +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", current='" + current + '\'' +
                '}';
    }
}
