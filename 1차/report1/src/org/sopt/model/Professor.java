package org.sopt.model;

/**
 * Created by ds on 2018-09-28.
 */
public class Professor extends Department{
    //교수 고유 번호
    private int professorIdx;
    //교수 이름
    private String professorName;
    //교수 학과

    //교수 전화번호
    private String professorPhone;
    //담당 과목
    private String subject;

    public Professor(){}

    public Professor(final int professorIdx, final String professorName, final String professorPhone, final String subject) {
        super();
        this.professorIdx = professorIdx;
        this.professorName = professorName;
        this.professorPhone = professorPhone;
        this.subject = subject;
    }

    public Professor(final int universityIdx, final String universityName, final String universityPhone, final String universityAddress, final int departmentIdx, final String departmentName, final String departmentPhone, final String departmentType, final int professorIdx, final String professorName, final String professorPhone, final String subject) {
        super(universityIdx, universityName, universityPhone, universityAddress, departmentIdx, departmentName, departmentPhone, departmentType);
        this.professorIdx = professorIdx;
        this.professorName = professorName;
        this.professorPhone = professorPhone;
        this.subject = subject;
    }

    public int getProfessorIdx() {
        return professorIdx;
    }

    public void setProfessorIdx(final int professorIdx) {
        this.professorIdx = professorIdx;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(final String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorPhone() {
        return professorPhone;
    }

    public void setProfessorPhone(final String professorPhone) {
        this.professorPhone = professorPhone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "professorIdx=" + professorIdx +
                ", professorName='" + professorName + '\'' +
                ", professorPhone='" + professorPhone + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
