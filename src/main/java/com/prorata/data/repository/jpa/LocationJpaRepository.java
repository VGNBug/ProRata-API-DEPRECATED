package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.LocationEntity;

/**
 * Repository : Location.
 */
public interface LocationJpaRepository extends PagingAndSortingRepository<LocationEntity, Integer> {

}
