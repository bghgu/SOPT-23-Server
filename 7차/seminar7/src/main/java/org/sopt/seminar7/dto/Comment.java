package org.sopt.seminar7.dto;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by ds on 2018-12-04.
 */

@Data
public class Comment {
    private int commentIdx;
    private int userIdx;
    private String body;
    private int likeCount;
    private DateTime createDate;
}
