package org.sopt.model.builder;

import org.sopt.model.Department;

/**
 * Created by ds on 2018-09-28.
 */
public class DepartmentBuilder {
    //학과 고유 번호
    private int departmentIdx;
    //학과 이름
    private String departmentName;
    //학과 전화번호
    private String departmentPhone;
    //학과 타입(공대, 자연대, 사범대, 치대..)
    private String departmentType;

    public DepartmentBuilder setDepartmentIdx(final int departmentIdx) {
        this.departmentIdx = departmentIdx;
        return this;
    }

    public DepartmentBuilder setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public DepartmentBuilder setDepartmentPhone(final String departmentPhone) {
        this.departmentPhone = departmentPhone;
        return this;
    }

    public DepartmentBuilder setDepartmentType(final String departmentType) {
        this.departmentType = departmentType;
        return this;
    }

    public Department build() {
        return new Department(this.departmentIdx, this.departmentName, this.departmentPhone, this.departmentType);
    }
}
