package org.sopt.seminar8.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * Created by ds on 2018-12-24.
 */


@Data
//Spring Data JPA를 위한 Annotation
@Entity
//JPA 테이블 이름 명시
//테이블 네임 맵핑 기본값은 첫글자 대문자 (ex. Item)
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Indexed
    private String name = "test";
}
