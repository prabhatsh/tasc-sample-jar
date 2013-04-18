/**
 * 
 */
package com.tasconline.sample;

/**
 * Another business interface.
 * No implementation of this interface is provided in this example project.
 * 
 * This interface will be used to demonstrate how Mockito can be used to simulate a collaborating 
 * interface's behavior.
 * 
 * @author nicholasbl
 */
public interface OtherBusinessInterface {

	/**
	 * Creates and persists a {@link SampleBusinessObject} with the provided data.
	 * 
	 * @param data
	 * @return the persisted {@link SampleBusinessObject}. May return null
	 * @throws BusinessException if a problem prevents the creation of a {@link SampleBusinessObject}
	 */
	SampleBusinessObject createBusinessObject(String data) throws BusinessException;
}
