/**
 * 
 */
package com.tasconline.sample;

/**
 * Sample of a business interface.
 * 
 * @author nicholasbl
 */
public interface SampleBusinessInterface {

	/**
	 * Locates the {@link SampleBusinessObject} identified the data argument.
	 * Returns null if not found.
	 * 
	 * @param data
	 * @return the corresponding {@link SampleBusinessObject}, or null if not found.
	 */
	SampleBusinessObject getObjectWithData(String data);
}
