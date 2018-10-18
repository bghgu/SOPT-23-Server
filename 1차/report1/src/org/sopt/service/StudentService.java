package org.sopt.service;

import org.sopt.model.Student;

/**
 * Created by ds on 2018-09-28.
 */

public interface StudentService {
    //학번으로 학생 조회
    Student getByStudentIdx(final int studentIdx);
}
