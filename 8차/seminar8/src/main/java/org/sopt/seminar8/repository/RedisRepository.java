package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ds on 2018-12-26.
 */

public interface RedisRepository extends JpaRepository<Token, String> {
}
