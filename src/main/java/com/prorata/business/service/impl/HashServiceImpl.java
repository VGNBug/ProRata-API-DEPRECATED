package com.prorata.business.service.impl;

import org.springframework.stereotype.Component;

import com.prorata.business.service.HashService;

/**
 * {@inheritDoc}
 */
@Component
public class HashServiceImpl implements HashService
{
	/**
	 * {@inheritDoc}
	 */
	public String decode(String encodedValue)
	{
		String decodedValue = encodedValue;// TODO decode value
		return decodedValue;
	}
}
