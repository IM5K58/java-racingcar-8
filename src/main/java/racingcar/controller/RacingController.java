package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.RacingCarList;
import racingcar.model.Separator;
import racingcar.model.Validator;

import java.util.HashSet;

public class RacingController {

    public void run(){
        Input input = new Input();
        Output output = new Output();
        Separator separator = new Separator();
        Validator validator = new Validator();

        output.whatIsName();
        RacingCarList cars = new RacingCarList();
        String string = input.inputName();
        HashSet<String>carNames = separator.splitAndReturn(string);
        validator.validate(carNames);

        for(String carName : carNames){
            RacingCar racingCar = new RacingCar(carName);
            cars.addRacingCar(racingCar);
        }

        output.howManyTrials();
        int trials = input.inputTrials();
        output.showTrialResultHeader();
        for(int i = 0; i < trials; i++){
            cars.racingGame();
            output.showRoundResult(cars);
        }
        output.showWinners(cars);
    }
}
