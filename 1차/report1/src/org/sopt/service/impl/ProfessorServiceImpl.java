package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.service.ProfessorService;

/**
 * Created by ds on 2018-09-28.
 */
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorBuilder professorBuilder = new ProfessorBuilder();

    @Override
    public Professor getByProfessorIdx(final int professorIdx) {
        return professorBuilder
                .setProfessorIdx(professorIdx)
                .build();
    }
}
