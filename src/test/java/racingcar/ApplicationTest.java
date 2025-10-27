package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("기본 상황에서의 출력")
    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @DisplayName("중복된이름이 입력에 있을 시 처리 확인")
    @Test
    void 기능_테스트_중복_이름_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("여러 경우의 테스트")
    @ParameterizedTest
    @MethodSource("tester")
    void 다중_테스트_실행(String input, String trial) {
        assertSimpleTest(() -> {
            run(input, trial);
        });
    }
    static Stream<Arguments> tester() {
        return Stream.of(
                Arguments.of("pobi,kyum,won,jang","5"),
                Arguments.of("pobi,kyum,won,jang","10"),
                Arguments.of("won,won,won,won","6")

        );
    }

    @DisplayName("5글자 이상의 문자열이 들어간 경우의 예외 처리 확인")
    @Test
    void 예외_테스트_5글자_이상() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("이름으로 적은 글자에 숫자나 알파벳을 제외한 문자가 포함된 경우")
    @Test
    void 예외_테스트_예외_문자사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Pobi,b@n", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
