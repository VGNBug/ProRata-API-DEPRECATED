package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.SubscriptionTypeEntity;

/**
 * Repository : SubscriptionType.
 */
public interface SubscriptionTypeJpaRepository extends PagingAndSortingRepository<SubscriptionTypeEntity, Integer> {

}
