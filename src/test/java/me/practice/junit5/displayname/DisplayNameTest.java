package me.practice.junit5.displayname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@DisplayName("디스플레이 네임 테스트")
public class DisplayNameTest {

	@Test
	@DisplayName("디스플레이 네임")
	void 테스트() {

	}

	@Test
	@DisplayName("╯°□°）╯")
	void 특수문자() {

	}

	@Test
	@DisplayName("😭")
	void 이모지() {

	}
}
