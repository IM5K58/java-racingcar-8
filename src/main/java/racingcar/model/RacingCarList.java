package racingcar.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RacingCarList {
    private ArrayList<RacingCar>racingCarList;
    public RacingCarList() {
        this.racingCarList = new ArrayList<RacingCar>();
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public void racingGame(int n){
        for(int i=0; i<n; i++){
            for(RacingCar racingCar : racingCarList){
                racingCar.race();
                racingCar.raceResult();
            }
            System.out.println();
        }
    }
    private ArrayList<RacingCar> findRacingWinner(){
        RacingCar racingCarFirstProgress = racingCarList.get(0);
        for(RacingCar racingCar : racingCarList){
            if(racingCar.isAhead(racingCarFirstProgress)){
                racingCarFirstProgress = racingCar;
            }
        }

        ArrayList<RacingCar> racingWinner = new ArrayList<>();
        for(RacingCar racingCar : racingCarList){
            if(racingCar.hasSameProgress(racingCarFirstProgress)){
                racingWinner.add(racingCar);
            }
        }
        return racingWinner;
    }
    public void PrintWinners(){
        ArrayList<RacingCar> winners = findRacingWinner();
        System.out.print("최종 우승자: ");
        for(int i=0; i<winners.size(); i++){
            System.out.print(winners.get(i).name());
            if(!(i == winners.size()-1)){
                System.out.print(", ");
            }
        }
    }
}
