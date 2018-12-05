package org.sopt.seminar7.dto;

import lombok.Data;

/**
 * Created by ds on 2018-11-28.
 */

@Data
public class User {
    private int userIdx;
    private String name;
    private String email;
    private String profileUrl;
    private boolean auth;
}
