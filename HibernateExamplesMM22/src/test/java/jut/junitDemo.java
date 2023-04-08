package jut;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class junitDemo {

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void test() {
		System.out.println("@Test");
	}
	
	@Test
	public void testA() {
		System.out.println("@TestA");
	}
	
	@Test
	public void testB() {
		System.out.println("@TestB");
	}

}
