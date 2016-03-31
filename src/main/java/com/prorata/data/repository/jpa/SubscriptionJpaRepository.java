package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.SubscriptionEntity;

/**
 * Repository : Subscription.
 */
public interface SubscriptionJpaRepository extends PagingAndSortingRepository<SubscriptionEntity, Integer> {

}
