package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.RacingCar;
public class RacingController {
    Input input = new Input();
    Output output = new Output();

    public void run(){
        output.whatIsName();
        RacingCar car = new RacingCar(input.input_name());
        output.howManyTrials();
        int trials = input.input_trials();
        output.showTrialResult();
        for(int i= 0; i < trials; i++){
            car.race();
            car.raceResult();
        }
    }
}
