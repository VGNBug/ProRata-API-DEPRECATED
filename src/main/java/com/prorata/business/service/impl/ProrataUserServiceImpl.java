/*
 * Created on 13 Feb 2016 ( Time 21:09:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.prorata.business.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.prorata.business.service.ProrataUserService;
import com.prorata.data.repository.jpa.AccountJpaRepository;
import com.prorata.data.repository.jpa.BankJpaRepository;
import com.prorata.data.repository.jpa.EmployerJpaRepository;
import com.prorata.data.repository.jpa.EmploymentJpaRepository;
import com.prorata.data.repository.jpa.ProrataUserJpaRepository;
import com.prorata.data.repository.jpa.SubscriptionJpaRepository;
import com.prorata.data.repository.jpa.SubscriptionTypeJpaRepository;
import com.prorata.data.repository.jpa.UserContactJpaRepository;
import com.prorata.model.jpa.AccountEntity;
import com.prorata.model.jpa.EmployerEntity;
import com.prorata.model.jpa.EmploymentEntity;
import com.prorata.model.jpa.ProrataUserEntity;
import com.prorata.model.jpa.SubscriptionEntity;
import com.prorata.model.jpa.SubscriptionTypeEntity;
import com.prorata.model.jpa.UserContactEntity;

/**
 * Implementation of {@link com.prorata.buisiness.service.ProrataUserService
 * ProrataUserService}
 */
@Component
public class ProrataUserServiceImpl implements ProrataUserService
{
	private static final Log LOGGER = LogFactory.getLog(ProrataUserService.class);
	
	@Resource
	private ProrataUserJpaRepository prorataUserJpaRepository;
	
	@Resource
	private SubscriptionTypeJpaRepository subscriptionTypeJpaRepository;
	
	@Resource
	private SubscriptionJpaRepository subscriptionJpaRepository;
	
	@Resource
	private AccountJpaRepository accountJpaRepository;
	
	@Resource
	private EmploymentJpaRepository employmentJpaRepository;
	
	@Resource
	private EmployerJpaRepository employerJpaRepository;
	
	@Resource
	private UserContactJpaRepository userContactJpaRepository;
	
	@Resource
	private BankJpaRepository bankJpaRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ProrataUserEntity findById(Integer prorataUserId)
	{
		String stateMessage = null;
		
		if (prorataUserId != null)
		{
			ProrataUserEntity response = prorataUserJpaRepository.findOne(prorataUserId);
			
			if (response != null)
			{
				LOGGER.info("Retrieved user with ID " + prorataUserId + " with the following details: "
						+ response.toString());
				return response;
			}
			else
			{
				stateMessage = "User with ID of " + prorataUserId + " could not be found.";
				DataRetrievalFailureException e = new DataRetrievalFailureException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
		}
		else
		{
			stateMessage = "User ID cannot be null.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<ProrataUserEntity> findAll()
	{
		List<ProrataUserEntity> response = new ArrayList<>();
		
		for (ProrataUserEntity entity : prorataUserJpaRepository.findAll())
		{
			response.add(entity);
		}
		
		return response;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ProrataUserEntity create(ProrataUserEntity user)
	{
		String stateMessage = null;
		
		if (user != null)
		{
			if (user.getEmail() != null && user.getPassword() != null)
			{
				// Create the user.
				ProrataUserEntity response = prorataUserJpaRepository.save(user);
				
				if (response != null)
				{
					stateMessage = "User with email " + user.getEmail() + " created successfully. State is as follows: "
							+ user.toString();
					LOGGER.info(stateMessage);
					
					// Persist all collections included with this user.
					persistCollections(user, response);
					
					// Set the user with a default subscription if they do not
					// have one included.
					if (user.getListOfSubscription() == null || user.getListOfSubscription().isEmpty())
					{
						this.setSubscription(response, 0);
					}
					
					return this.initializeCollections(response);
				}
				else
				{
					stateMessage = "User with email " + user.getEmail() + " was not updated successfully.";
					IllegalArgumentException e = new IllegalArgumentException(stateMessage);
					LOGGER.error(e);
					throw e;
				}
			}
			else if (user.getEmail() == null && user.getPassword() != null)
			{
				stateMessage = "update user failed: Email cannot be null.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
			else if (user.getEmail() != null && user.getPassword() == null)
			{
				stateMessage = "update user failed: Password cannot be null.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
			else
			{
				stateMessage = "update user failed: Neither email nor password can be null";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
		}
		else
		{
			stateMessage = "No user was supplied to be updated.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ProrataUserEntity update(ProrataUserEntity user)
	{
		String stateMessage = null;
		
		if (user != null && user.getEmail() != null && user.getPassword() != null)
		{
			ProrataUserEntity checkedUser = checkCredentials(user.getEmail(), user.getPassword());
			
			if (checkedUser != null)
			{
				user.setProrataUserId(checkedUser.getProrataUserId());
				
				// Update the user.
				ProrataUserEntity persistedUser = prorataUserJpaRepository.save(user);
				
				// Persist all collections included with this user.
				persistCollections(user, persistedUser);
				
				return persistedUser;
			}
			else
			{
				stateMessage = "Incorrect username or pasword.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(stateMessage, e);
				throw e;
			}
			
		}
		else
		{
			stateMessage = "update user failed: Neither email nor password can be null";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ProrataUserEntity signIn(ProrataUserEntity credentials)
	{
		String stateMessage = null;
		
		if (credentials != null)
		{
			if (credentials.getEmail() != null && credentials.getPassword() != null)
			{
				// Get the user
				ProrataUserEntity response = checkCredentials(credentials.getEmail(), credentials.getPassword());
				
				// Check that the user returned is not null, and report on it.
				if (response != null)
				{
					stateMessage = "User with the following details was recovered by " + this.getClass().getSimpleName()
							+ ": " + response.toString();
					LOGGER.info(stateMessage);
					return response;
				}
				else
				{
					stateMessage = "User was not recovered successfully.";
					DataRetrievalFailureException e = new DataRetrievalFailureException(stateMessage);
					LOGGER.error(e);
					throw e;
				}
			}
			else if (credentials.getEmail() != null && credentials.getPassword() == null)
			{
				stateMessage = "Read user failed: password cannot be null.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
			else if (credentials.getEmail() == null && credentials.getPassword() != null)
			{
				stateMessage = "Read user failed: email cannot be null.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
			else
			{
				stateMessage = "Read user failed: email and password must be provided.";
				IllegalArgumentException e = new IllegalArgumentException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
		}
		else
		{
			stateMessage = "User credentials must be supplied to allow access to user data.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public String delete(ProrataUserEntity credentials)
	{
		String stateMessage = null;
		
		if (credentials != null && credentials.getEmail() != null && credentials.getPassword() != null)
		{
			// Delete the user.
			prorataUserJpaRepository.delete(checkCredentials(credentials.getEmail(), credentials.getPassword()));
			
			stateMessage = "User with email " + credentials.getEmail() + " deleted successfully.";
			LOGGER.info(stateMessage);
			return stateMessage;
		}
		
		else if (credentials.getEmail() == null && credentials.getPassword() != null)
		{
			stateMessage = "delete user failed: Email cannot be null.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
		else if (credentials.getEmail() != null && credentials.getPassword() == null)
		{
			stateMessage = "delete user failed: Password cannot be null.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
		else
		{
			stateMessage = "delete user failed: Neither email nor password can be null";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * Will retrieve a user with an email and password which match those
	 * supplied.
	 * 
	 * @param email
	 *            A String used to identify the
	 *            {@link com.prorata.model.jpa.ProrataUserEntity#email} of the
	 *            {@link com.prorata.model.jpa.ProrataUserEntity} to be
	 *            returned.
	 * @param password
	 *            A String which matches the
	 *            {@link com.prorata.model.jpa.ProrataUserEntity#password} of
	 *            the {@link com.prorata.model.jpa.ProrataUserEntity} recovered
	 *            by email.
	 * @return A matching {@link com.prorata.model.jpa.ProrataUserEntity}
	 */
	private ProrataUserEntity checkCredentials(String email, String password)
	{
		ProrataUserEntity response = null;
		
		if (email != null && password != null)
		{
			ProrataUserEntity matchByEmail = this.prorataUserJpaRepository.findByEmail(email);
			
			if (matchByEmail != null && password.equals(matchByEmail.getPassword()))
			{
				response = this.initializeCollections(matchByEmail);
			}
			else
			{
				String stateMessage = "User with email " + email + " was not found.";
				DataRetrievalFailureException e = new DataRetrievalFailureException(stateMessage);
				LOGGER.error(e);
				throw e;
			}
		}
		
		return response;
	}
	
	/**
	 * This will set a {@link com.prorata.model.jpa.SubscriptionEntity
	 * subscription} on a persisted
	 * {@link com.prorata.model.jpa.ProrataUserEntity user}.
	 * 
	 * @param user
	 *            The {@link com.prorata.model.jpa.ProrataUserEntity user} for
	 *            the {@link com.prorata.model.jpa.SubscriptionEntity
	 *            subscription} to be set on.
	 * @param subscriptionTypeId
	 *            The
	 *            {@link com.prorata.model.jpa.SubscriptionTypeEntity#subscriptionTypeId}
	 *            of the {@link com.prorata.model.jpa.SubscriptionTypeEntity
	 *            subscription-type} of the
	 *            {@link com.prorata.model.jpa.SubscriptionEntity subscription}
	 *            to be added to the
	 *            {@link com.prorata.model.jpa.ProrataUserEntity user}.
	 * @return The newly created {@link com.prorata.model.jpa.Subscription
	 *         subscription}.
	 */
	private SubscriptionEntity setSubscription(ProrataUserEntity user, Integer subscriptionTypeId)
	{
		String stateMessage = null;
		
		if (user.getProrataUserId() != null && subscriptionTypeJpaRepository.findOne(subscriptionTypeId) != null)
		{
			SubscriptionTypeEntity subType = subscriptionTypeJpaRepository.findOne(subscriptionTypeId);
			
			SubscriptionEntity subscription = new SubscriptionEntity();
			subscription.setProrataUser(user);
			subscription.setSubscriptionType(subscriptionTypeJpaRepository.findOne(subscriptionTypeId));
			subscription.setStartDateTime(Calendar.getInstance().getTime());
			
			stateMessage = "A subscription with the following type was added to the user with ID + "
					+ user.getProrataUserId() + ": " + subType.toString();
			LOGGER.info(stateMessage);
			
			return this.subscriptionJpaRepository.save(subscription);
		}
		else if (user.getProrataUserId() == null)
		{
			stateMessage = "Adding subscription to user failed: User must be persisted and must have an ID in order to add a subscription to them";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
		else if (subscriptionTypeJpaRepository.findOne(subscriptionTypeId) == null)
		{
			stateMessage = "Adding subscription to user failed due to attempt to add a subscription to user with a non-existant SubscriptionType.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
		else
		{
			stateMessage = "Adding subscription to user failed due to an unknown error.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * Persists all entities in collections held by the
	 * {@link com.prorata.model.jpa.ProrataUserEntity user}.
	 * 
	 * @param user
	 *            The {@link com.prorata.model.jpa.ProrataUserEntity user} who's
	 *            collections are to be persisted.
	 */
	@Transactional
	private void persistCollections(ProrataUserEntity user, ProrataUserEntity persistedUser)
	{
		String stateMessage = null;
		
		if (user != null && persistedUser.getProrataUserId() != null)
		{
			if (user.getListOfAccount() != null)
			{
				// TODO no need to persist the bank- this should be provided as
				// a list in the client rather than letting users create them.
				for (AccountEntity account : user.getListOfAccount())
				{
					account.setBank(bankJpaRepository.findOne(1));
					account.setProrataUser(persistedUser);
					accountJpaRepository.save(account);
					LOGGER.info("Added the following account to user with ID " + user.getProrataUserId() + ": "
							+ account.toString());
				}
			}
			if (user.getListOfEmployment() != null)
			{
				for (EmploymentEntity employment : user.getListOfEmployment())
				{
					EmployerEntity employer = null;
					
					if (employment.getEmployer() != null)
					{
						employer = employment.getEmployer();
					}
					else
					{
						employer = new EmployerEntity();
						employer.setName("Undeclaired Employer");
						employment.setEmployer(employer);
						employerJpaRepository.save(employer);
						LOGGER.info("Created employer for employent " + employment.toString());
					}
					
					employment.setProrataUser(persistedUser);
					employmentJpaRepository.save(employment);
					LOGGER.info("Added the following account to user with ID " + user.getProrataUserId() + ": "
							+ employment.toString());
				}
			}
			if (user.getListOfSubscription() != null)
			{
				for (SubscriptionEntity subscription : user.getListOfSubscription())
				{
					if (subscription.getSubscriptionType() != null)
					{
						subscription.setProrataUser(persistedUser);
						subscriptionJpaRepository.save(subscription);
						LOGGER.info("Added the following subscription to user with ID " + user.getProrataUserId() + ": "
								+ subscription.toString());
					}
				}
			}
			if (user.getListOfUserContact() != null)
			{
				for (UserContactEntity contact : user.getListOfUserContact())
				{
					contact.setProrataUser(persistedUser);
					userContactJpaRepository.save(contact);
					LOGGER.info("Added the following contact to user with ID " + user.getProrataUserId() + ": "
							+ contact.toString());
				}
			}
		}
		else if (persistedUser.getProrataUserId() == null)
		{
			stateMessage = "Persistence of AccountEntities failed: Suppled perisisted ProrataUserEntity ID must not be null.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
		else
		{
			stateMessage = "Persistence of AccountEntities failed: Suppled ProrataUserEntity must not be null.";
			IllegalArgumentException e = new IllegalArgumentException(stateMessage);
			LOGGER.error(e);
			throw e;
		}
	}
	
	/**
	 * Calls {@link org.hibernate.Hibernate#initialize(Object)} on all
	 * collections within a supplied
	 * {@link com.prorata.model.jpa.ProrataUseEntity ProrataUserEntity}, as well
	 * as collections within those collections if necessary.
	 * 
	 * @param user
	 *            The {@link com.prorata.model.jpa.ProrataUserEntity
	 *            ProrataUserEntity} who's collections are to be initialised.
	 * @return The supplied @link com.prorata.model.jpa.ProrataUserEntity user},
	 *         with it's collections initialised.
	 */
	private ProrataUserEntity initializeCollections(ProrataUserEntity user)
	{
		Hibernate.initialize(user.getListOfSubscription());
		Hibernate.initialize(user.getListOfAccount());
		Hibernate.initialize(user.getListOfEmployment());
		Hibernate.initialize(user.getListOfUserContact());
		
		if (user.getListOfEmployment() != null)
		{
			for (EmploymentEntity employment : user.getListOfEmployment())
			{
				Hibernate.initialize(employment.getListOfEmploymentSession());
				Hibernate.initialize(employment.getListOfContract());
				Hibernate.initialize(employment.getListOfPayment());
				Hibernate.initialize(employment.getEmployer());
			}
		}
		
		return user;
	}
}
