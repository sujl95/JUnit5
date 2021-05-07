package me.practice.junit5.displayname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("디스플레이 네임 생성자 테스트")
public class DisplayNameGeneratorTest {

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class A_년은_지원하지않는다 {

		@Test
		void zero_일때() {

		}

		@DisplayName("윤년 계산할 때 음수 값은 지원하지 않는다.")
		@ParameterizedTest(name = "예를 들어, {0} 년은 지원하지 않는다.")
		@ValueSource(ints = {-1, -4})
		void 부정적일때(int year) {

		}

	}

	@Nested
	@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
	class A_년은_윤년이다 {

		@Test
		void 윤년을_4로_나눌수_있지만_100으로_나누지못한다() {

		}

		@ParameterizedTest(name = "{0} 년은 윤년이다.")
		@ValueSource(ints = {2016, 2020, 2048})
		void 다음의_값들은_윤년(int year) {

		}

	}

}
