package org.sopt.service;

import org.sopt.model.Professor;

/**
 * Created by ds on 2018-09-28.
 */
public interface ProfessorService {
    //교수 고유 번호로 조회
    Professor getByProfessorIdx(final int professorIdx);
}
