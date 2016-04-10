package com.prorata.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prorata.business.service.ProrataUserService;
import com.prorata.model.jpa.ProrataUserEntity;
import com.prorata.business.service.HashService;
import com.prorata.rest.exception.proratauser.ProrataUserNotFoundException;
import com.prorata.rest.exception.proratauser.*;

@RestController
@RequestMapping(value = "/prorataUser")
public class ProrataUserRestController
{
	private ObjectMapper mapper;
	
	@Autowired
	private ProrataUserService prorataUserService;
	
	@Autowired
	private HashService hashService;
	
	public ProrataUserRestController()
	{
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	
	/**
	 * <p>
	 * Persists a POSTed {@link com.prorata.model.jpa.ProrataUserEntity
	 * ProrataUserEntity}, returning it if successful.
	 * </p>
	 * 
	 * @param user
	 *            The user to be created.
	 * @return The created user, if successful.
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ProrataUserEntity create(final @RequestBody Map<String, Object> userMap)
			throws ProrataUserServiceException
	{
		prorataUserService.create(mapper.convertValue(userMap, ProrataUserEntity.class));
		return prorataUserService.signIn((String)userMap.get("email"), (String)userMap.get("password"));
	}
	
	/**
	 * <p>
	 * User sign in service: {@link com.prorata.model.jpa.Prorata#email email}
	 * and {@link com.prorata.model.jpa.Prorata#password password} strings are
	 * POSTed to the controller, which will call
	 * {@link com.prorata.buisiness.service.ProrataUserService#signIn(java.util.Map)}
	 * to return a matching {@link com.prorata.model.jpa.ProrataUserEntity
	 * ProrataUserEntity} if one can be found.
	 * </p>
	 * 
	 * <p>
	 * This method can read objects within collections from the persisted
	 * entity, and can return them as nested objects within arrays withing the
	 * returned JSON object.
	 * </p>
	 * 
	 * @param emailHash
	 *         An encoded representation of the 
	 *         {@link com.prorata.model.jpa.ProrataUserEntity#email}
	 *         of the ProrataUser to be retrieved.
	 * @param passwordHash
	 *         An encoded representation of the 
	 *         {@link com.prorata.model.jpa.ProrataUserEntity#password}
	 *         of the ProrataUser to be retrieved.
	 * @return A {@link com.prorata.model.jpa.ProrataUserEntity
	 *         ProrataUserEntity} which matches the credentials, if one can be
	 *         found.
	 */
	@RequestMapping(value = "/emailHash{emailHash}/passwordHash{passwordHash}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	//@formatter:off
	public ProrataUserEntity read(
									@PathVariable String emailHash, 
									@PathVariable String passwordHash
								 )throws ProrataUserNotFoundException
	//@formatter:on
	{
		return prorataUserService.signIn(hashService.decode(emailHash), hashService.decode(passwordHash));
	}
	
	/**
	 * <p>
	 * Updates a persisted user.
	 * </p>
	 * 
	 * <p>
	 * This method cannot post collections into the persisted entity; those have
	 * to be posted separately via their respective controllers.
	 * </p>
	 * 
	 * @param user
	 *            A user object containing at least the correct
	 *            {@link com.prorata.model.jpa.ProrataUserEntity#email email}
	 *            and {@link com.prorata.model.jpa.ProrataUserEntity#password
	 *            password} for that user, as well as any attributes to be
	 *            changed.
	 * @return The updated {@link com.prorata.model.jpa.ProrataUserEntity
	 *         ProrataUserEntity}.
	 * @throws ProrataUserServiceErrorException
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public ProrataUserEntity update(final @RequestBody Map<String, Object> userMap)
			throws ProrataUserServiceErrorException
	{
		prorataUserService.update(mapper.convertValue(userMap, ProrataUserEntity.class));
		return prorataUserService.signIn((String)userMap.get("email"), (String)userMap.get("password"));
	}
	
	/**
	 * Deletes a user. Requires a JSON object containing the "email" and
	 * "password" of the user to be deleted.
	 * 
	 * @param user
	 *            A user object containing at least the correct
	 *            {@link com.prorata.model.jpa.ProrataUserEntity#email email}
	 *            and {@link com.prorata.model.jpa.ProrataUserEntity#password
	 *            password} for the user to be deleted.
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(final @RequestBody Map<String, Object> credentials) throws ProrataUserServiceErrorException
	{
		prorataUserService.delete(mapper.convertValue(credentials, ProrataUserEntity.class));
	}
	
}
