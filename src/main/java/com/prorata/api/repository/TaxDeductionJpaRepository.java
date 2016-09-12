package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.TaxDeductionEntity;

/**
 * Repository : TaxDeduction.
 */
public interface TaxDeductionJpaRepository extends PagingAndSortingRepository<TaxDeductionEntity, Integer> {

}
