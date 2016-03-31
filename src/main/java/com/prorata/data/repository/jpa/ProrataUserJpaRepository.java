package com.prorata.data.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prorata.model.jpa.ProrataUserEntity;

/**
 * Repository : ProrataUser.
 */
public interface ProrataUserJpaRepository extends CrudRepository<ProrataUserEntity, Integer>
{
	/**
	 * Returns a single {@link com.prorata.model.jpa.ProrataUserEntity
	 * ProrataUserEntity} if one with a matching
	 * {com.prorata.model.jpa.ProrataUser#email email} can be found.
	 * 
	 * @param string
	 *            The {@link com.prorata.model.jpa.ProrataUserEntity#email
	 *            email} to search by.
	 * @return A single {@link com.prorata.model.jpa.ProrataUserEntity
	 *         ProrataUserEntity} with a matching
	 *         {@link com.prorata.model.jpa.ProrataUserEntity#email email}.
	 */
	
	@Query("SELECT p FROM ProrataUserEntity p WHERE p.email = ?1")
	ProrataUserEntity findByEmail(String email);
}
