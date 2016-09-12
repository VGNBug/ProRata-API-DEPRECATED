package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.AccountEntity;

/**
 * Repository : Account.
 */
public interface AccountJpaRepository extends PagingAndSortingRepository<AccountEntity, Integer> {

}
