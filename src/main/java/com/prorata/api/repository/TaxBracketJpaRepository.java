package com.prorata.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.api.model.TaxBracketEntity;

/**
 * Repository : TaxBracket.
 */
public interface TaxBracketJpaRepository extends PagingAndSortingRepository<TaxBracketEntity, Integer> {

}
