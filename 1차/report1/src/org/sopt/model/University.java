package org.sopt.model;

/**
 * Created by ds on 2018-09-28.
 */

public class University {
    //대학 고유 번호
    private int universityIdx;
    //대학 이름
    private String universityName;
    //대학 전화번호
    private String universityPhone;
    //대학 주소
    private String universityAddress;

    public University() {}

    public University(final int universityIdx, final String universityName, final String universityPhone, final String universityAddress) {
        this.universityIdx = universityIdx;
        this.universityName = universityName;
        this.universityPhone = universityPhone;
        this.universityAddress = universityAddress;
    }

    public int getUniversityIdx() {
        return universityIdx;
    }

    public void setUniversityIdx(final int universityIdx) {
        this.universityIdx = universityIdx;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(final String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityPhone() {
        return universityPhone;
    }

    public void setUniversityPhone(final String universityPhone) {
        this.universityPhone = universityPhone;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(final String universityAddress) {
        this.universityAddress = universityAddress;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityIdx=" + universityIdx +
                ", universityName='" + universityName + '\'' +
                ", universityPhone='" + universityPhone + '\'' +
                ", universityAddress='" + universityAddress + '\'' +
                '}';
    }
}
