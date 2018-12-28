package org.sopt.seminar8.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by ds on 2018-12-26.
 */

@Data
//Spring Data Redis를 위한 Annotation
@RedisHash("token")
public class Token {

    //기본키 설정
    @Id
    private String token;

    //세컨더리 인덱스
    @Indexed
    private String name = "test";
}
