package org.sopt.seminar8.domain.redis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by ds on 2018-12-24.
 */

@Data
//Spring Data Redis를 위한 Annotation
@RedisHash("item")
public class Token {

    @Id
    private int sessionId;

    @Indexed
    private String Name = "test";
}
