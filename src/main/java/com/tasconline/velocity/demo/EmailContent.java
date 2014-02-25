/**
 * 
 */
package com.tasconline.velocity.demo;

import java.util.Map;

/**
 * Object representing email content.
 * @author prabhats
 *
 */
public class EmailContent {
	
	private String salutation;
	private String toName;
	private Map<String, String> contentVariables;
	private Map<String, String> signature;
	
	/**
	 * 
	 * @return Salutation used in email. (For example Dear, Mr., Miss, Mrs etc..)
	 */
	public String getSalutation() {
		return salutation;
	}
	
	/**
	 * 
	 * @param salutation Salutation used in email. (For example Dear, Mr., Miss, Mrs etc..)
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	/**
	 * 
	 * @return Name to whom email is addressed.
	 */
	public String getToName() {
		return toName;
	}
	
	/**
	 * 
	 * @param toName Name to whom email is addressed.
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	
	/**
	 * 
	 * @return {@link Map} of variables that will replace tokens placed within velocity email template. 
	 */
	public Map<String, String> getContentVariables() {
		return contentVariables;
	}
	
	/**
	 * 
	 * @param contentVairables
	 */
	public void setContentVriables(Map<String, String> contentVariables) {
		this.contentVariables = contentVariables;
	}
	
	/**
	 * Signature within an email can have for example name of the email sender, cell, email addresses etc.
	 * @return
	 */
	public Map<String, String> getSignature() {
		return signature;
	}
	
	/**
	 * 
	 * @param signature
	 */
	public void setSignature(Map<String, String> signature) {
		this.signature = signature;
	}
}
