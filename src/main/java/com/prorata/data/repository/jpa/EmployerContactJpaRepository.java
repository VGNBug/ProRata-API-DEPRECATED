package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.EmployerContactEntity;

/**
 * Repository : EmployerContact.
 */
public interface EmployerContactJpaRepository extends PagingAndSortingRepository<EmployerContactEntity, Integer> {

}
