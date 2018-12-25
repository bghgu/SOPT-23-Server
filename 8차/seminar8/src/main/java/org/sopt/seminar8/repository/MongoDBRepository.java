package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Item;

/**
 * Created by ds on 2018-12-23.
 */

/**
 * Spring Data MongoDB
 */

public interface MongoDBRepository extends org.springframework.data.mongodb.repository.MongoRepository<Item, Integer> {

}
