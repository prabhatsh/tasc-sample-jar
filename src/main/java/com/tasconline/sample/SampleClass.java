/**
 * 
 */
package com.tasconline.sample;

import java.io.IOException;
import java.util.Properties;

import com.tasconline.TascException;

/**
 * Simple class with a TASC dependency.
 * 
 * @author nicholasbl
 */
public class SampleClass {

	/**
	 * com.tasconline.TascException comes from the tasc-common artifact (groupId com.tasconline.core).
	 * If tasc-common can't be resolved, this won't compile.
	 * 
	 * @throws TascException
	 */
	public void throwTascException() throws TascException {
		throw new TascException();
	}
	
	/**
	 * The maven project structure separates "resources" from java source.
	 * This method depends on a file named "sample-file.properties" at the root of the classpath.
	 * That file is in the project under src/main/resources. At build time, it will be included in the jar (everything
	 * in src/main/resources automatically is included).
	 * 
	 * This method will return the value of the property if found, otherwise null.
	 * 
	 * @return the value of the property if found, otherwise null.
	 * @throws IOException if the property file couldn't be read.
	 */
	public String getValueFromPropertiesFile(String key) throws IOException {
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("sample-file.properties"));
		
		return properties.getProperty(key);
	}
}
