package org.sopt.seminar8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ds on 2018-12-26.
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor
//Spring Data JPA를 위한 Annotation
@Entity
//JPA 테이블 이름 명시, DB의 테이블 이름과 다를 경우 명시를 통해 매핑 가능
//테이블 네임 매핑 기본값은 첫글자 대문자 (ex. Item)
@Table(name = "item")
public class Item {

    //기본키 Annotation
    @Id
    //기본키 자동 생성, 기본키 생성을 DB에 맡긴다.
    //Mysql은 IDENTITY, Oracle은 SEQUENCE, 자동은 AUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //컬럼 이름 명시, DB의 컬럼 이름과 다를 경우 명시를 통해 매핑 가능
    @Column(name = "name")
    private String name;
}
