package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RacingCarOutputTest {

    @Test
    @DisplayName("우승자 한명일때 출력 테스트")
    public void winnerIsSoloTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        PrintStream original = System.out;

        try {
            System.setOut(ps);
            RacingCarOutput racingCarOutput = new RacingCarOutput();
            racingCarOutput.printFinalWinner(java.util.List.of("name"));

            String expected = "최종 우승자: " + "name";
            String actual = outputStream.toString().trim();

            assertEquals(expected, actual);
        } finally {
            System.setOut(original);
        }
    }

    @Test
    @DisplayName("우승자가 여러명일때 출력 테스트")
    public void winnerIsMultiTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        PrintStream original = System.out;

        try {
            System.setOut(ps);
            RacingCarOutput racingCarOutput = new RacingCarOutput();
            racingCarOutput.printFinalWinner(java.util.List.of("name", "name2"));

            String expected = "최종 우승자: " + "name, name2";
            String actual = outputStream.toString().trim();

            assertEquals(expected, actual);
        } finally {
            System.setOut(original);
        }
    }

    @Test
    @DisplayName("게임 횟수별 결과 출력 테스트")
    public void printRoundResultTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        PrintStream original = System.out;

        try{
            System.setOut(ps);
            RacingCarOutput racingCarOutput = new RacingCarOutput();
            Car mockCar = new Car("name");
            mockCar.move();
            racingCarOutput.printGameResult(java.util.List.of(mockCar));

            String expected = "name : -";
            String actual = outputStream.toString().trim();

            assertEquals(expected, actual);

        } finally {
            System.setOut(original);
        }
    }
}
