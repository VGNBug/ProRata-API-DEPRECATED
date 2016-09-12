package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.BankEntity;

/**
 * Repository : Bank.
 */
public interface BankJpaRepository extends PagingAndSortingRepository<BankEntity, Integer> {

}
