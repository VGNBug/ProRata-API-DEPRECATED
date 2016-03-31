package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.TaxDeductionEntity;

/**
 * Repository : TaxDeduction.
 */
public interface TaxDeductionJpaRepository extends PagingAndSortingRepository<TaxDeductionEntity, Integer> {

}
