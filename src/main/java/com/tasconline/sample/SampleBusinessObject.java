/**
 * 
 */
package com.tasconline.sample;

/**
 * Sample of a POJO business object.
 * 
 * @author nicholasbl
 */
public class SampleBusinessObject {

	private String data;
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SampleBusinessObject [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
}
