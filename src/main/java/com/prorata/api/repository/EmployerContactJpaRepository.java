package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.EmployerContactEntity;

/**
 * Repository : EmployerContact.
 */
public interface EmployerContactJpaRepository extends PagingAndSortingRepository<EmployerContactEntity, Integer> {

}
