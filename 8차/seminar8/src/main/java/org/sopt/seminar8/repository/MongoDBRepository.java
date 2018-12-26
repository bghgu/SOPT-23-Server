package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.mongo.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ds on 2018-12-23.
 */

/**
 * Spring Data MongoDB
 */

public interface MongoDBRepository extends MongoRepository<Content, Integer> {

}
