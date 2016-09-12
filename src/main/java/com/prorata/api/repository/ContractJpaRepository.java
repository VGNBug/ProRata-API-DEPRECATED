package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.ContractEntity;

/**
 * Repository : Contract.
 */
public interface ContractJpaRepository extends PagingAndSortingRepository<ContractEntity, Integer> {

}
