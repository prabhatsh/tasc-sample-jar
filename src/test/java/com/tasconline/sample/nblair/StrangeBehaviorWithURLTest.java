/**
 * 
 */
package com.tasconline.sample.nblair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for {@link StrangeBehaviorWithURL}.
 * 
 * @author nicholasbl
 */
public class StrangeBehaviorWithURLTest {

	/**
	 * Verify strange behavior. Note: this test may fail with non-deterministic results if
	 * your network connection is unavailable, or if the hosts referenced in {@link StrangeBehaviorWithURL#urls}
	 * are not available.
	 */
	@Test
	public void strange_behavior() {
		StrangeBehaviorWithURL strange = new StrangeBehaviorWithURL();
		assertEquals(2, strange.getSize1());
		assertEquals(1, strange.getSize2());
	}
}
