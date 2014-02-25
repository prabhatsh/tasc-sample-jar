/**
 * 
 */
package com.tasconline.velocity.demo;

import org.apache.velocity.VelocityContext;

/**
 * 
 * @author prabhats
 *
 */
public interface EmailContentGenerator {
	
	/**
	 * It expects path of apache velocity template (.vm), and {@link EmailContent} object.
	 * These email templates are to be created using Velocity Template Language. 
	 * Visit http://velocity.apache.org/engine/devel/vtl-reference-guide.html for detail.
	 * Object {@link EmailContent} contains attributes which are going to replace tokens placed within the template.
	 * {@link VelocityContext}  
	 * @param emailTemplate
	 * @param content
	 * @return
	 */
	public String createEmailContent(String emailTemplateName, EmailContent content);

}
