/**
 * 
 */
package com.tasconline.sample;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.tasconline.TascException;

/**
 * Tests for {@link SampleClass}.
 * 
 * @author nicholasbl
 */
public class SampleClassTest {

	/**
	 * Trivial test demonstrating JUnit usage within maven project.
	 */
	@Test
	public void testThrow() {
		SampleClass instance = new SampleClass();
		try {
			instance.throwTascException();
			Assert.fail("expected TascException not thrown");
		} catch (TascException e) {
			// success!
		}
	}
	
	@Test
	public void testGetProperty() throws IOException {
		SampleClass instance = new SampleClass();
		Assert.assertNull(instance.getValueFromPropertiesFile("not-there"));
		Assert.assertEquals("somevalue", instance.getValueFromPropertiesFile("somekey"));
	}
}
