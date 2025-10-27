package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

import java.util.ArrayList;

public class Output {

    private static final String MOVE_SIGN = "-";

    public void whatIsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void howManyTrials(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showTrialResultHeader(){
        System.out.println("실행 결과");
    }

    public void showRoundResult(RacingCarList racingCars) {
        for (RacingCar car : racingCars.getCarList()) {
            String progress = MOVE_SIGN.repeat(car.getProgress());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }

    public void showWinners(RacingCarList racingCars) {
        ArrayList<RacingCar> winners = racingCars.findRacingWinner();
        System.out.print("최종 우승자 : ");
        writeDownWinners(winners);
    }

    private void writeDownWinners(ArrayList<RacingCar> winners) {
        for(int i = 0; i < winners.size(); i++){
            System.out.print(winners.get(i).getName());
            if(!(i == winners.size()-1)){
                System.out.print(", ");
            }
        }
    }
}
