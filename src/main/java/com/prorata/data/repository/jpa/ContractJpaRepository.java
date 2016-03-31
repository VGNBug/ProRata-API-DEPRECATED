package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.ContractEntity;

/**
 * Repository : Contract.
 */
public interface ContractJpaRepository extends PagingAndSortingRepository<ContractEntity, Integer> {

}
