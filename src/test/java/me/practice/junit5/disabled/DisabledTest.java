package me.practice.junit5.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {

	@Disabled("버그 #42가 해결 될 때까지 테스트 비활성화")
	@Test
	void testWillBeSkipped() {
	}

	@Test
	void testWillBeExecuted() {
	}
	
}
