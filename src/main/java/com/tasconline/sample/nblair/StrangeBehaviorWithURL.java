/**
 * 
 */
package com.tasconline.sample.nblair;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * This class demonstrates some strange behavior with {@link URL}.
 * 
 * Don't use {@link URL} in collections.
 * 
 * @see {@link URL#equals(Object)}
 * @author Nicholas Blair
 */
public class StrangeBehaviorWithURL {

	protected static final String[] urls = new String[] { 
		"http://httpd.apache.org", 
		"http://tomcat.apache.org", };
	
	/**
	 * 
	 * @return the number of urls
	 */
	public int getSize1() {
		return urls.length;
	}
	/**
	 * 
	 * @return the number of {@link URL}s
	 */
	public int getSize2() {
		Set<URL> set = new HashSet<URL>();
		for(String url: urls) {
			set.add(urlQuietly(url));
		}
		return set.size();
	}
	/**
	 * Convenience method to make failure to construct a {@link URL}
	 * from the specified {@link String} a runtime problem.
	 * 
	 * @see URL
	 * @param value
	 * @return the {@link URL}
	 * @throws IllegalArgumentException if the value caused a {@link MalformedURLException} to be thrown
	 */
	private URL urlQuietly(String value) {
		try {
			return new URL(value);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("bug", e);
		}
	}
}
