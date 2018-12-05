package org.sopt.seminar7.dto;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by ds on 2018-11-30.
 */

@Data
public class Content {
    private int contentIdx;
    private int userIdx;
    private String body;
    private int likeCount;
    private Date createDate;
}
