package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.AccountEntity;

/**
 * Repository : Account.
 */
public interface AccountJpaRepository extends PagingAndSortingRepository<AccountEntity, Integer> {

}
