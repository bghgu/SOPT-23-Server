package org.sopt.model;

/**
 * Created by ds on 2018-09-28.
 */
public class Department extends University{
    //학과 고유 번호
    private int departmentIdx;
    //학과 이름
    private String departmentName;
    //학과 전화번호
    private String departmentPhone;
    //학과 타입(공대, 자연대, 사범대, 치대..)
    private String departmentType;

    public Department() {}

    public Department(final int departmentIdx, final String departmentName, final String departmentPhone, final String departmentType) {
        super();
        this.departmentIdx = departmentIdx;
        this.departmentName = departmentName;
        this.departmentPhone = departmentPhone;
        this.departmentType = departmentType;
    }

    public Department(final int universityIdx, final String universityName, final String universityPhone, final String universityAddress, final int departmentIdx, final String departmentName, final String departmentPhone, final String departmentType) {
        super(universityIdx, universityName, universityPhone, universityAddress);
        this.departmentIdx = departmentIdx;
        this.departmentName = departmentName;
        this.departmentPhone = departmentPhone;
        this.departmentType = departmentType;
    }

    public int getDepartmentIdx() {
        return departmentIdx;
    }

    public void setDepartmentIdx(final int departmentIdx) {
        this.departmentIdx = departmentIdx;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(final String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(final String departmentType) {
        this.departmentType = departmentType;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentIdx=" + departmentIdx +
                ", departmentName='" + departmentName + '\'' +
                ", departmentPhone='" + departmentPhone + '\'' +
                ", departmentType='" + departmentType + '\'' +
                '}';
    }
}
