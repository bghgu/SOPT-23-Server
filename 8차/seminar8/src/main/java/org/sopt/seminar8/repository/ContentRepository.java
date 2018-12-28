package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ds on 2018-12-26.
 */

public interface ContentRepository extends MongoRepository<Content, Integer> {
}
