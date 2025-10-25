package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.RacingCarList;
import racingcar.model.Separator;
import racingcar.model.Validator;

import java.util.HashSet;

public class RacingController {
    Input input = new Input();
    Output output = new Output();

    public void run(){
        Separator separator = new Separator();
        Validator validator = new Validator();

        output.whatIsName();

        RacingCarList cars = new RacingCarList();
        String string = input.input_name();
        HashSet<String>carNames = separator.splitAndReturn(string);
        validator.validate(carNames);

        for(String carName : carNames){
            RacingCar racingCar = new RacingCar(carName);
            cars.addRacingCar(racingCar);
        }
        output.howManyTrials();
        int trials = input.input_trials();
        output.showTrialResultHeader();
        for(int i = 0; i < trials; i++){
            cars.racingGame();
            output.showTrialResult(cars);
        }
        output.showWinners(cars);
    }
}
