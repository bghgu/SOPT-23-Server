package org.sopt.service.impl;

import org.sopt.model.University;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.UniversityService;

/**
 * Created by ds on 2018-09-28.
 */
public class UniversityServiceImpl implements UniversityService {

    private UniversityBuilder universityBuilder = new UniversityBuilder();

    @Override
    public University getByUniversityIdx(final int universityIdx) {
        return universityBuilder
                .setUniversityIdx(universityIdx)
                .build();
    }
}
