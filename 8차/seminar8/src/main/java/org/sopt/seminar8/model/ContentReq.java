package org.sopt.seminar8.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by ds on 2018-12-19.
 */

@Data
public class ContentReq {

    private int contentIdx;
    private int userIdx;
    private String body;
    private MultipartFile[] photo;
    private Date createdDate = new Date();
}
