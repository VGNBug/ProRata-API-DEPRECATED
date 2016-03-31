package com.prorata.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.prorata.model.jpa.TaxBracketEntity;

/**
 * Repository : TaxBracket.
 */
public interface TaxBracketJpaRepository extends PagingAndSortingRepository<TaxBracketEntity, Integer> {

}
