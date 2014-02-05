/**
 * 
 */
package com.tasconline.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * This test demonstrates how to use Mockito to create a 
 * Unit Test for {@link DelegatingSampleBusinessInterfaceImpl}.
 * 
 * Note that {@link DelegatingSampleBusinessInterfaceImpl} depends
 * on implementations of {@link OtherBusinessInterface} being provided at construction time.
 * This project doesn't have a single implementation of {@link OtherBusinessInterface}.
 * 
 * This mimics a common scenario: you have an EJB that depends on one or more other collaborating
 * business interfaces. 
 * Bootstrapping all of the collaborators isn't necessary, nor does it meet the definition of a "unit test."
 * A unit test is focused on the logic of the single class it tests, not the logic of the collaborating classes.
 * 
 * Here mockito is used to supply implementations of {@link OtherBusinessInterface} that behave in the way
 * described in the {@link OtherBusinessInterface} javadocs.
 *  
 * Take note of the use of "import static" - if you are unfamiliar with this construct, it allows you to refer to 
 * static methods in other classes just by method name instead of class.method.
 * It's not necessary, but in classes that use Mockito's static methods over and over it can provide a few 
 * less keystrokes for the developer.
 * 
 * Example: mock() invokes {@link Mockito#mock(Class)}
 * 
 * @author nicholasbl
 */
public class DelegatingSampleBusinessInterfaceImplTest {

	/**
	 * Test behavior when empty list of delegates provided (always returns null).
	 */
	@Test 
	public void testNoDelegates() {
		List<OtherBusinessInterface> delegates = Collections.emptyList();
		DelegatingSampleBusinessInterfaceImpl service = new DelegatingSampleBusinessInterfaceImpl(delegates);
		assertNull(service.getObjectWithData("foo"));
		assertNull(service.getObjectWithData("bar"));
	}
	/**
	 * "Control" experiment: we have a single {@link OtherBusinessInterface} and it successfully
	 * returns a response for a specific case.
	 * Assert the {@link DelegatingSampleBusinessInterfaceImpl#getObjectWithData(String)} returns
	 * the expected instance.
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void testControl() throws BusinessException {
		SampleBusinessObject expected = new SampleBusinessObject();
		expected.setData("bar");
		OtherBusinessInterface delegate = mock(OtherBusinessInterface.class);
		when(delegate.createBusinessObject("foo")).thenReturn(expected);
		
		List<OtherBusinessInterface> delegates = Arrays.asList(new OtherBusinessInterface[] { delegate });
		DelegatingSampleBusinessInterfaceImpl service = new DelegatingSampleBusinessInterfaceImpl(delegates);
		assertEquals(expected, service.getObjectWithData("foo"));
	}
	/**
	 * Test behavior when a single {@link OtherBusinessInterface} is provided that throws an exception
	 * on the createBusinessObject method.
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void testSingleInterfaceThrowsException() throws BusinessException {
		OtherBusinessInterface delegate = mock(OtherBusinessInterface.class);
		when(delegate.createBusinessObject("foo")).thenThrow(new BusinessException());
		
		List<OtherBusinessInterface> delegates = Arrays.asList(new OtherBusinessInterface[] { delegate });
		DelegatingSampleBusinessInterfaceImpl service = new DelegatingSampleBusinessInterfaceImpl(delegates);
		assertNull(service.getObjectWithData("foo"));
	}
	/**
	 * Test behavior when a single {@link OtherBusinessInterface} is provided that throws an exception
	 * on the createBusinessObject method.
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void testMultipleInterfaces() throws BusinessException {
		SampleBusinessObject expected = new SampleBusinessObject();
		expected.setData("bar");
		
		OtherBusinessInterface delegate1 = mock(OtherBusinessInterface.class);
		when(delegate1.createBusinessObject("foo")).thenThrow(new BusinessException());
		// note the use of Mockito#isA - this means ANY String input will result in the thenReturn
		OtherBusinessInterface delegate2 = mock(OtherBusinessInterface.class);
		when(delegate2.createBusinessObject(isA(String.class))).thenReturn(expected);
		
		List<OtherBusinessInterface> delegates = Arrays.asList(new OtherBusinessInterface[] { delegate1, delegate2 });
		DelegatingSampleBusinessInterfaceImpl service = new DelegatingSampleBusinessInterfaceImpl(delegates);
		assertEquals(expected, service.getObjectWithData("foo"));
	}
}
