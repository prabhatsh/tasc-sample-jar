/**
 * 
 */
package com.tasconline.sample;

import java.util.List;

/**
 * Implementation of {@link SampleBusinessInterface} that delegates to a
 * {@link List} of {@link OtherBusinessInterface}s implementations, which is required
 * at construction time.
 * 
 * @author nicholasbl
 */
public class DelegatingSampleBusinessInterfaceImpl implements SampleBusinessInterface {

	private final List<OtherBusinessInterface> otherBusinessInterfaces;
	/**
	 * @param otherBusinessInterfaces
	 */
	public DelegatingSampleBusinessInterfaceImpl(
			List<OtherBusinessInterface> otherBusinessInterfaces) {
		this.otherBusinessInterfaces = otherBusinessInterfaces;
	}

	/**
	 * Calls {@link OtherBusinessInterface#createBusinessObject(String)} on each configured
	 * instance, returns the first non-null result.
	 * 
	 * If all of the {@link OtherBusinessInterface#createBusinessObject(String)} invocations
	 * fail throwing {@link BusinessException}s, this method returns null.
	 * 
	 * @see com.tasconline.sample.SampleBusinessInterface#getObjectWithData(java.lang.String)
	 */
	@Override
	public SampleBusinessObject getObjectWithData(String data) {
		for(OtherBusinessInterface businessInterface: otherBusinessInterfaces) {
			try {
				SampleBusinessObject object = businessInterface.createBusinessObject(data);
				if(object != null) {
					return object;
				}
			} catch(BusinessException e) {
				// log and try the next businessinterface
			}
		}
		
		return null;
	}

}
