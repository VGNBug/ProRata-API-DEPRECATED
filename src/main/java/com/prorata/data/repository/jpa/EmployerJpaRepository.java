package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.EmployerEntity;

/**
 * Repository : Employer.
 */
public interface EmployerJpaRepository extends PagingAndSortingRepository<EmployerEntity, Integer> {

}
