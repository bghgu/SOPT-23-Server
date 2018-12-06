package org.sopt.seminar7.dto;

import lombok.Data;

/**
 * Created by ds on 2018-12-06.
 */

@Data
public class ContentPhoto {
    //사진 고유 번호
    private int photoIdx;
    //컨텐츠 고유 번호
    private int contentIdx;
    //사진 주소
    private String photoUrl;
}
