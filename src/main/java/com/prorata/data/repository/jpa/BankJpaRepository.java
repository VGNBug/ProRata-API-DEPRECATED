package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.BankEntity;

/**
 * Repository : Bank.
 */
public interface BankJpaRepository extends PagingAndSortingRepository<BankEntity, Integer> {

}
