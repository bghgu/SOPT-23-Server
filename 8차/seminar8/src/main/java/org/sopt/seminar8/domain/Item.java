package org.sopt.seminar8.domain;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

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
//Spring Data Redis를 위한 Annotation
@RedisHash("item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //세컨더리 인덱스
    @Indexed
    private String name = "test";
}
