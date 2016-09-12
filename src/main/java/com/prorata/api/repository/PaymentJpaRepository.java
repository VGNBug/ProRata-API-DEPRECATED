package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.PaymentEntity;

/**
 * Repository : Payment.
 */
public interface PaymentJpaRepository extends PagingAndSortingRepository<PaymentEntity, Integer> {

}
