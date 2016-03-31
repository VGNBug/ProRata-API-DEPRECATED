package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.EmploymentSessionEntity;

/**
 * Repository : EmploymentSession.
 */
public interface EmploymentSessionJpaRepository extends PagingAndSortingRepository<EmploymentSessionEntity, Integer> {

}
