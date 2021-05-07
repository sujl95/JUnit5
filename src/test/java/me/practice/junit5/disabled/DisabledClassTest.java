package me.practice.junit5.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("버그 #99가 수정 될 때까지 테스트 비활성화")
public class DisabledClassTest {

	@Test
	void testWillBeSkipped() {
	}

}
