package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.PayChequeEntity;

/**
 * Repository : PayCheque.
 */
public interface PayChequeJpaRepository extends PagingAndSortingRepository<PayChequeEntity, Integer> {

}
