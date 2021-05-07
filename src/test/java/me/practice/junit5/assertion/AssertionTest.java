package me.practice.junit5.assertion;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;

import me.practice.junit5.Calculator;
import me.practice.junit5.Person;

public class AssertionTest {

	private final Calculator calculator = new Calculator();
	private final Person person = new Person("성준", "이");

	@Test
	void standardAssertions() {
		assertEquals(2, calculator.add(1, 1));
		assertEquals(4, calculator.multiply(2, 2),
				"실패 메시지는 마지막 파라미터에 넣는다.");
		assertTrue('a' < 'b', "Assertion 메시지는 지연로딩과 비슷하게 동작 불필요하게 메시지를 만드는일을 피하기 위해서이다");
	}

	@Test
	void groupedAssertions() {
		assertAll("person",
				() -> assertEquals("성준", person.getFirstName()),
				() -> assertEquals("이", person.getLastName())
		);
	}

	@Test
	void exceptionTesting() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	void timeoutNotExceeded() {
		assertTimeout(ofMinutes(2), () -> {
		});
	}

	@Test
	void timeoutNotExceededWithResult() {
		String actualResult = assertTimeout(ofMinutes(2), () -> "a result");
		assertEquals("a result", actualResult);
	}

	@Test
	void timeoutExceeded() {
		// fail
		assertTimeout(ofMillis(10), () -> Thread.sleep(100));
	}

	@Test
	void timeoutExceededWithPreemptiveTermination() {
		// fail
		assertTimeoutPreemptively(ofMillis(10), () -> new CountDownLatch(1).await());
	}
}
