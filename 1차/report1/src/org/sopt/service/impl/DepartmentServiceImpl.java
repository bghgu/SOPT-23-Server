package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

/**
 * Created by ds on 2018-09-28.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentBuilder departmentBuilder = new DepartmentBuilder();

    @Override
    public Department getByDepartmentIdx(final int departmentIdx) {
        return departmentBuilder
                .setDepartmentIdx(departmentIdx)
                .build();
    }
}
