package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.LocationEntity;

/**
 * Repository : Location.
 */
public interface LocationJpaRepository extends PagingAndSortingRepository<LocationEntity, Integer> {

}
