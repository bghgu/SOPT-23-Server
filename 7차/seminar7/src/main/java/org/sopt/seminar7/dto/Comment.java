package org.sopt.seminar7.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by ds on 2018-12-04.
 */

@Data
public class Comment {
    //댓글 고유 번호
    private int commentIdx;
    //작성자 고유 번호
    private int userIdx;
    //댓글 내용
    private String body;
    //좋아요 갯수
    private int likeCount;
    //작성 날짜
    private Date createDate;
    //컨텐츠 고유 번호
    private int contentIdx;
    //댓글 수정 및 삭제 권한
    private boolean auth;
    //좋아요 여부
    private boolean like;
}
