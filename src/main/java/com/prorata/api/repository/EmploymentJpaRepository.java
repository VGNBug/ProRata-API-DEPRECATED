package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.EmploymentEntity;

/**
 * Repository : Employment.
 */
public interface EmploymentJpaRepository extends PagingAndSortingRepository<EmploymentEntity, Integer> {

}
