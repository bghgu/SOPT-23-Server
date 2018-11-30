package org.sopt.seminar7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ds on 2018-11-30.
 */

@Data
@NoArgsConstructor
public class Content {
    private int contentIdx;
    private String title;
    private String body;
    private String photoUrl;
    private int writerIdx;
}
