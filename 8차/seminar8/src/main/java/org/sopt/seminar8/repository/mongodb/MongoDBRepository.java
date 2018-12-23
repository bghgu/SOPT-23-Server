package org.sopt.seminar8.repository.mongodb;

import org.sopt.seminar8.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ds on 2018-12-23.
 */
public interface MongoDBRepository extends MongoRepository<User, Integer> {
}
