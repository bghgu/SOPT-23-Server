package org.sopt.seminar8.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ds on 2018-12-24.
 */


@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name = "test";
}
