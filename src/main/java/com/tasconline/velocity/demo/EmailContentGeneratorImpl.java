/**
 * 
 */
package com.tasconline.velocity.demo;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * 
 * @author prabhats
 *
 */
public class EmailContentGeneratorImpl implements EmailContentGenerator {
	
	private VelocityEngine velocityEngine;
	
	/**
	 *  Velocity's runtime configuration is controlled by a set of configuration keys
	 *  There is a set of default values contained in Velocity's jar, found in /src/java/org/apache/velocity/runtime/defaults/velocity.defaults, 
	 *  that Velocity uses as it's configuration baseline. This ensures that Velocity will always have a 'correct' value for it's 
	 *  configuration keys at startup, although it may not be what you want. Any values specified before init() time will replace the default values.
	 *  
	 *  In the constructor here, velocity engine's logging is suppressed. This is achieved by setting "runtime.log.logsystem.class"="org.apache.velocity.runtime.log.NullLogSystem"
	 *  Note:  {@link VelocityEngine#setProperty(String, Object)} must be called before {@link VelocityEngine#init()}, for overriding default setting/s.
	 * 
	 */
	public EmailContentGeneratorImpl() {
		this.velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogSystem" );
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
