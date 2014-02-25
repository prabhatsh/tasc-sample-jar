/**
 * 
 */
package com.tasconline.velocity.demo;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * 
 * @author prabhats
 *
 */
public class EmailContentGeneratorImpl implements EmailContentGenerator {
	
	private VelocityEngine velocityEngine;
	
	/**
	 * @see VelocityEngine#init()
	 * 
	 */
	public EmailContentGeneratorImpl() {
		this.velocityEngine = new VelocityEngine();
		velocityEngine.init();
	}
	
	
	/**
	 * @see VelocityEngine
	 * @param velocityEngine
	 */
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	/**
	 * {@link VelocityContext} is central to Velocity API, it servers the purpose of a container for moving data 
	 * around between Java Layer and Template Layer. {@link VelocityContext#put(String, Object)} puts object in the context and is assigned a name, 
	 * this name is going to be used within the template for accessing the attributes of the object. 
	 * 
	 */
	@Override
	public String createEmailContent(String emailTemplate, EmailContent content) {
		VelocityContext context = new VelocityContext();
		context.put("email", content);
		Template template = velocityEngine.getTemplate(emailTemplate);
        StringWriter writer = new StringWriter();  
        template.merge( context, writer );  
        return writer.toString();
	}

}
