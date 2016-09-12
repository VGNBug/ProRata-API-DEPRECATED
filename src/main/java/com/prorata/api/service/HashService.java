package com.prorata.api.service;

/**
 * Utility hash decoder
 */
public interface HashService
{
	/**
	 * Decodes an encoded String.
	 *
	 * @param encodedValue The String to be decoded.
	 */
	public String decode(String encodedValue);
}
