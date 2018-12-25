package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.redis.Token;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ds on 2018-12-24.
 */
public interface RedisRepository extends CrudRepository<Token, Integer> {

    @Modifying
    @Transactional
    void deleteByName(final String name);
}
