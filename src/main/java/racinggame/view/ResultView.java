package racinggame.view;

import racinggame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(List<Car> allCars) {
        for (Car car : allCars) {
            StringBuilder resultString = new StringBuilder(car.getName());
            resultString.append(" : ");
            resultString.append(generatePositionString(car.getPosition()));
            System.out.println(resultString.toString());
        }
        System.out.println();
    }

    private static String generatePositionString(int position) {
        StringBuilder positionString = new StringBuilder();
        for (int roundPosition = 0; roundPosition < position; roundPosition++) {
            positionString.append("-");
        }
        return positionString.toString();
    }

    public static void printWinner(List<Car> winners) {
        StringBuilder winnerResult = new StringBuilder();
        winnerResult.append(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
        winnerResult.append("가 최종 우승했습니다");
        System.out.println(winnerResult);
    }
}
