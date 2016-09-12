package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.EmployerEntity;

/**
 * Repository : Employer.
 */
public interface EmployerJpaRepository extends PagingAndSortingRepository<EmployerEntity, Integer> {

}
