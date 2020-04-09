package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private List<Car> allCars;
    private int rounds;
    private List<Car> moveResult = new ArrayList<>();

    public RacingGame(List<String> carNames, int rounds) {
        this.allCars = new ArrayList<>(carNames.size());
        this.rounds = rounds;
        for (String carName : carNames) {
            Car racingCar = new Car(carName);
            allCars.add(racingCar);
        }
    }

    public List<Car> allRounds() {
        for (int round = 0; round < rounds; round++) {
            this.racing();
        }
        return moveResult;
    }

    private void racing() {
        for (Car car : allCars) {
            moveNowCar(car);
            moveResult.add(car.clone());
        }
    }

    private void moveNowCar(Car nowCar) {
        if (this.moveOrNot()) {
            nowCar.moveCar();
        }
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }

    private boolean moveOrNot() {
        return this.getRandomNum() >= MOVE_CONDITION;
    }

    public List<Car> findWinners() {
        List<Car> racingResults = this.allCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
        return new Winner(racingResults).findWinnerNames();
    }
}
