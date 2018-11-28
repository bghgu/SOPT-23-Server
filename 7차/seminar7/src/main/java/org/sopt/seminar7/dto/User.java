package org.sopt.seminar7.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ds on 2018-11-28.
 */

@Setter
@NoArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String part;
    private String profileUrl;
}
