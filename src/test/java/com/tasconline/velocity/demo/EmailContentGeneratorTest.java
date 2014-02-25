/**
 * 
 */
package com.tasconline.velocity.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * This test demonstrates how to use Apache Velocity Template api to generate email content out of a template.
 * Here {@link EmailContent} object contains attribute which will be used to replace tokens within the 
 * email template emailtemplate.vm.
 * @author prabhats
 *
 */
public class EmailContentGeneratorTest {
	
	/**
	 * Test that all the tokens within emailtemplate.vm is successfully replaced from 
	 * {@link EmailContent} object. Note, that user of the {@link EmailContentGenerator} must be aware of the tokens
	 * placed within the emailtemplate.vm template.
	 */
	@Test
	public void test_success_all_parameters_replaced_createEmailContent() {
		EmailContentGenerator eg = new EmailContentGeneratorImpl();
		
		EmailContent content = new EmailContent();
		content.setSalutation("Dear");
		content.setToName("Tasc");
		Map<String, String> contentVariables = new  HashMap<String, String>();
		contentVariables.put("var1", "content variable 1 from context");
		contentVariables.put("var2", "content variable 2 from context");
		
		Map<String, String> signature = new  HashMap<String, String>();
		signature.put("name", "Prabhat Sharma");
		signature.put("email", "PrabhatS@tasconline.com");
		signature.put("cell", "989-9999-999");
		signature.put("office", "989-9999-222");
		
		content.setContentVairables(contentVariables);
		content.setSignature(signature);		
		
		String emailContent = eg.createEmailContent("/src/test/resources/emailtemplate.vm", content);
		Assert.assertTrue(emailContent.contains("Dear"));
		Assert.assertTrue(emailContent.contains("Tasc"));
		Assert.assertTrue(emailContent.contains("content variable 1 from context"));
		Assert.assertTrue(emailContent.contains("content variable 2 from context"));
		Assert.assertTrue(emailContent.contains("Prabhat Sharma"));
		Assert.assertTrue(emailContent.contains("PrabhatS@tasconline.com"));
		Assert.assertTrue(emailContent.contains("989-9999-999"));
		Assert.assertTrue(emailContent.contains("989-9999-222"));
	}

}
