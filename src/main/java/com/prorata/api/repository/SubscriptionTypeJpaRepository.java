package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.SubscriptionTypeEntity;

/**
 * Repository : SubscriptionType.
 */
public interface SubscriptionTypeJpaRepository extends PagingAndSortingRepository<SubscriptionTypeEntity, Integer> {

}
