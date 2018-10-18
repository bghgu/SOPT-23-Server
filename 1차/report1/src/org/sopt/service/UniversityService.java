package org.sopt.service;

import org.sopt.model.University;

/**
 * Created by ds on 2018-09-28.
 */
public interface UniversityService {
    //대학 이름으로 조회
    University getByUniversityIdx(final int universityIdx);
}
