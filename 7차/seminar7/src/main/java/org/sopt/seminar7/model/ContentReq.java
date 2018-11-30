package org.sopt.seminar7.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ds on 2018-11-30.
 */

@Setter
@NoArgsConstructor
public class ContentReq {

    private String title;
    private String body;
    private MultipartFile photo;
}
