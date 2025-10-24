package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;
public class RacingController {
    Input input = new Input();
    Output output = new Output();

    public void run(){
        output.whatIsName();
        RacingCarList cars = new RacingCarList();
        for(int i = 0; i < 5; i++){
            RacingCar car = new RacingCar(input.input_name());
            cars.addRacingCar(car);
        }
        output.howManyTrials();
        int trials = input.input_trials();
        cars.racingGame(trials);
        output.showTrialResult();
        cars.PrintWinners();
    }
}
