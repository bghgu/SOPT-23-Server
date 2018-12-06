package org.sopt.seminar7.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by ds on 2018-12-06.
 */

@Data
public class CommentReq {

    private int commentIdx;
    private int userIdx;
    private String body;
    private Date createdDate = new Date();
    private int contentIdx;

    public boolean checkProperties() {
        return body != null;
    }
}
