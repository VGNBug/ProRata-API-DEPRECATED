package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.UserContactEntity;

/**
 * Repository : UserContact.
 */
public interface UserContactJpaRepository extends PagingAndSortingRepository<UserContactEntity, Integer> {

}
