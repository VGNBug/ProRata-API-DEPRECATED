package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.PayChequeEntity;

/**
 * Repository : PayCheque.
 */
public interface PayChequeJpaRepository extends PagingAndSortingRepository<PayChequeEntity, Integer> {

}
