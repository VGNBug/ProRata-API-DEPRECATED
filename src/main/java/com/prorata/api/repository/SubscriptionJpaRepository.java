package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.SubscriptionEntity;

/**
 * Repository : Subscription.
 */
public interface SubscriptionJpaRepository extends PagingAndSortingRepository<SubscriptionEntity, Integer> {

}
