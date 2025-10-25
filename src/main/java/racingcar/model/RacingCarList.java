package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarList {
    private ArrayList<RacingCar>racingCarList;
    public RacingCarList() {
        this.racingCarList = new ArrayList<RacingCar>();
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public void racingGame(){
        for(RacingCar racingCar:racingCarList){
            racingCar.race();
        }
    }

    public ArrayList<RacingCar> findRacingWinner(){
        RacingCar maxProgress = findMaxProgress();
        ArrayList<RacingCar> racingWinner = new ArrayList<>();
        for(RacingCar racingCar : racingCarList){
            if(racingCar.hasSameProgress(maxProgress)){
                racingWinner.add(racingCar);
            }
        }
        return racingWinner;
    }

    private RacingCar findMaxProgress() {
        RacingCar maxProgress = racingCarList.getFirst();
        for(RacingCar racingCar : racingCarList){
            if(racingCar.isAhead(maxProgress)){
                maxProgress = racingCar;
            }
        }
        return maxProgress;
    }

    public List<RacingCar> getCarList(){
        return Collections.unmodifiableList(racingCarList);
    }
}
