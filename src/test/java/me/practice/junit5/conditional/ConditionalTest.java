package me.practice.junit5.conditional;

import static org.junit.jupiter.api.condition.OS.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

public class ConditionalTest {

	@Test
	@EnabledOnOs(MAC)
	void onlyOnMacOs() {

	}

	@TestOnMac
	void testOnMac() {

	}

	@Test
	@EnabledOnOs({LINUX, MAC})
	void onLinuxOrMac() {

	}

	@Test
	@DisabledOnOs(WINDOWS)
	void notOnWindows() {

	}

	@Test
	@EnabledOnOs(WINDOWS)
	void testOnWindow() {

	}
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@EnabledOnOs(MAC)
@interface TestOnMac {

}