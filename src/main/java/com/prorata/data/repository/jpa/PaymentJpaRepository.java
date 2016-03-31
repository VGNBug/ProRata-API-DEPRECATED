package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.PaymentEntity;

/**
 * Repository : Payment.
 */
public interface PaymentJpaRepository extends PagingAndSortingRepository<PaymentEntity, Integer> {

}
