package org.sopt.model.builder;

import org.sopt.model.University;

/**
 * Created by ds on 2018-09-28.
 */
public class UniversityBuilder {
    //대학 고유 번호
    private int universityIdx;
    //대학 이름
    private String universityName;
    //대학 전화번호
    private String universityPhone;
    //대학 주소
    private String universityAddress;

    public UniversityBuilder setUniversityIdx(final int universityIdx) {
        this.universityIdx = universityIdx;
        return this;
    }

    public UniversityBuilder setUniversityName(final String universityName) {
        this.universityName = universityName;
        return this;
    }

    public UniversityBuilder setUniversityPhone(final String universityPhone) {
        this.universityPhone = universityPhone;
        return this;
    }

    public UniversityBuilder setUniversityAddress(final String universityAddress) {
        this.universityAddress = universityAddress;
        return this;
    }

    public University build() {
        return new University(this.universityIdx, this.universityName, this.universityPhone, this.universityAddress);
    }
}
