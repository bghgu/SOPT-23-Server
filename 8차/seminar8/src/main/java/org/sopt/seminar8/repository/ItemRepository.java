package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ds on 2018-12-19.
 */

/**
 * Spring Data JPA
 */

public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Modifying
    @Transactional
    void deleteByName(final String name);
}
