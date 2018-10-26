package org.sopt.seminar3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by ds on 2018-10-14.
 */

@Data
@AllArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String part;
}
