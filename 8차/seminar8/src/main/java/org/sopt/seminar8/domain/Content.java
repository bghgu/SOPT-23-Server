package org.sopt.seminar8.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ds on 2018-12-19.
 */

@Data
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentIdx;

    private String body;
    private int likeCount;
    private Date createDate;
}
