package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.EmploymentEntity;

/**
 * Repository : Employment.
 */
public interface EmploymentJpaRepository extends PagingAndSortingRepository<EmploymentEntity, Integer> {

}
