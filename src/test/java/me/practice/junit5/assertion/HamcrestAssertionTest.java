package me.practice.junit5.assertion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.Test;

import me.practice.junit5.Calculator;

public class HamcrestAssertionTest {

	private final Calculator calculator = new Calculator();

	@Test
	void assertWithHamcrestMatcher() {
		assertThat(calculator.subtract(4, 1), is(equalTo(3)));
	}

}
