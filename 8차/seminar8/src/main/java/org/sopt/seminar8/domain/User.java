package org.sopt.seminar8.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * Created by ds on 2018-12-19.
 */

@Data
@Entity
@Table(name = "user")
@Document
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdx;

    private String name;

    private String email;
    private String profileUrl;
}
