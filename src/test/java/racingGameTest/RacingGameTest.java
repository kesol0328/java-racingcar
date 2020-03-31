package racingGameTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    void createCarsTest() {
        String data = "pobi,crong,honux";
        assertThat(data.split(",").length).isEqualTo(3);    //길이 확인
        assertThat(data.split(",")).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("Test for 'moveOrNot'")
    @Test
    void moveOrNotTest() {
        assertThat(racingGame.moveOrNot(0)).isFalse();
        assertThat(racingGame.moveOrNot(3)).isFalse();
        assertThat(racingGame.moveOrNot(4)).isTrue();
        assertThat(racingGame.moveOrNot(9)).isTrue();
    }
}
