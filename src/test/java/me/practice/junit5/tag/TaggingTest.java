package me.practice.junit5.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
public class TaggingTest {

	@Test
	@Tag("taxes")
	void testingTaxCalculation() {

	}
}
