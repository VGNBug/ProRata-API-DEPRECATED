package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.UserContactEntity;

/**
 * Repository : UserContact.
 */
public interface UserContactJpaRepository extends PagingAndSortingRepository<UserContactEntity, Integer> {

}
