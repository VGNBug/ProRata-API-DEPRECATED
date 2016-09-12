package com.prorata.api.service.impl;

import com.prorata.api.service.HashService;
import org.springframework.stereotype.Component;

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
