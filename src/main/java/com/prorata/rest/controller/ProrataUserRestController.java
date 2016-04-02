package com.prorata.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prorata.business.service.ProrataUserService;
import com.prorata.model.jpa.ProrataUserEntity;
import com.prorata.rest.exception.proratauser.ProrataUserNotFoundException;
import com.prorata.rest.exception.proratauser.ProrataUserServiceErrorException;

@RestController
@RequestMapping(value = "/prorataUser")
public class ProrataUserRestController
{
	private ObjectMapper mapper;
	
	@Autowired
	private ProrataUserService prorataUserService;
	
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
	 * <p>
	 * This method cannot post collections into the persisted entity; those have
	 * to be posted separately via their respective controllers.
	 * </p>
	 * 
	 * @param user
	 *            The user to be created.
	 * @return The created user, if successful.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ProrataUserEntity create(final @RequestBody Map<String, Object> userMap)
			throws ProrataUserServiceErrorException
	{
		prorataUserService.create(mapper.convertValue(userMap, ProrataUserEntity.class));
		return prorataUserService.signIn(mapper.convertValue(userMap, ProrataUserEntity.class));
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
	 * @param credentials
	 *            A map of the {@link com.prorata.model.jpa.Prorata#email email}
	 *            and {@link com.prorata.model.jpa.Prorata#password password}
	 *            expected of the {@link com.prorata.model.jpa.ProrataUserEntity
	 *            ProrataUserEntity} to be returned, as strings.
	 * @return A {@link com.prorata.model.jpa.ProrataUserEntity
	 *         ProrataUserEntity} which matches the credentials, if one can be
	 *         found.
	 */
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ProrataUserEntity read(final @RequestBody Map<String, Object> credentials)
			throws ProrataUserNotFoundException
	{
		return prorataUserService.signIn(mapper.convertValue(credentials, ProrataUserEntity.class));
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
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ProrataUserEntity update(final @RequestBody Map<String, Object> userMap)
			throws ProrataUserServiceErrorException
	{
		prorataUserService.update(mapper.convertValue(userMap, ProrataUserEntity.class));
		return prorataUserService.signIn(mapper.convertValue(userMap, ProrataUserEntity.class));
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
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(final @RequestBody Map<String, Object> credentials) throws ProrataUserServiceErrorException
	{
		prorataUserService.delete(mapper.convertValue(credentials, ProrataUserEntity.class));
	}
	
}