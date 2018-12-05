package org.sopt.seminar7.model;

import lombok.Data;

/**
 * Created by ds on 2018-12-05.
 */

@Data
public class Pagination {
    private int offset = 0;
    private int limit = 10;
    private String keyword = "";
}
