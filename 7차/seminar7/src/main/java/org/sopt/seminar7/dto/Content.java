package org.sopt.seminar7.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by ds on 2018-11-30.
 */

@Data
public class Content {
    //컨텐츠 고유 번호
    private int contentIdx;
    //작성자 고유 번호
    private int userIdx;
    //사진
    private List<ContentPhoto> photo;
    //내용
    private String body;
    //좋아요 갯수
    private int likeCount;
    //작성 날짜
    private Date createDate;
    //컨텐츠 수정 및 삭제 권한
    private boolean auth;
    //좋아요 여부
    private boolean like;
}
