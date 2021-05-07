package me.practice.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StandardTests {

	@BeforeAll
	static void initAll() {
		System.out.println("BeforeAll");
	}

	@BeforeEach
	void init() {
		System.out.println("BeforeEach");
	}

	@Test
	void succeedingTest() {
		System.out.println("Test Success");
	}

	@Test
	void failingTest() {
		fail("a failing test");
	}

	@Test
	@Disabled("for demonstration purposes")
	void skippedTest() {
		// not executed
	}

	@Test
	void abortedTest() {
		assumeTrue("abc".contains("Z"));
		fail("test should have been aborted");
	}

	@AfterEach
	void tearDown() {
		System.out.println("AfterEach");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("AfterAll");
	}
}
