package me.practice.junit5.assumption;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;

import me.practice.junit5.Calculator;

public class AssumptionTest {

	private final Calculator calculator = new Calculator();

	@Test
	void testOnlyOnCiServer() {
		assumeTrue("CI".equals(System.getenv("ENV")));
	}

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")),
				() -> "Aborting test: not on developer workstation");
	}

	@Test
	void testInAllEnvironments() {
		assumingThat("CI".equals(System.getenv("ENV")), () -> {
			// CI 서버에서만 실행하는 테스트
			assertEquals(2, calculator.divide(4, 2));
		});
		// 모든 환경에서 실행하는 테스트
		assertEquals(42, calculator.multiply(6, 7));
	}
}
