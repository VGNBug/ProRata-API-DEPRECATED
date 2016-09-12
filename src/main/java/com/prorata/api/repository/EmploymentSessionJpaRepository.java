package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.EmploymentSessionEntity;

/**
 * Repository : EmploymentSession.
 */
public interface EmploymentSessionJpaRepository extends PagingAndSortingRepository<EmploymentSessionEntity, Integer> {

}
