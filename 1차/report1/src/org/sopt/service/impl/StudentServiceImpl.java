package org.sopt.service.impl;

import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.service.StudentService;

/**
 * Created by ds on 2018-09-28.
 */

public class StudentServiceImpl implements StudentService {

    private StudentBuilder studentBuilder = new StudentBuilder();

    @Override
    public Student getByStudentIdx(final int studentIdx) {
        return studentBuilder
                .setStudentIdx(studentIdx)
                .build();
    }
}
