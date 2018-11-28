package org.sopt.seminar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


/**
 * Created by ds on 2018-11-27.
 */

@Getter
@RedisHash("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Indexed
    private int id;

    private String name;
}
