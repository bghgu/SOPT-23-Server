package org.sopt.service;

import org.sopt.model.Department;

/**
 * Created by ds on 2018-09-28.
 */
public interface DepartmentService {
    //학과 이름으로 조회
    Department getByDepartmentIdx(final int departmentIdx);
}
