package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class RacingCar {
    private final String carName;
    private int raceProgressCount; // 이걸 분리?    

    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final int RANGE_LIMIT = 4;
    private static final int MOVE_VALUE = 1;
    private static final String MOVE_SIGN = "-";

    public RacingCar(String carName){
        this.carName = carName;
        raceProgressCount = 0;
    }

    public void race(){
        int randomNum = Randoms.pickNumberInRange(RANGE_START,RANGE_END);
        if(randomNum >= RANGE_LIMIT){
            raceProgressCount += MOVE_VALUE;
        }
    }

    public boolean isAhead(RacingCar compareCar) {
        return this.raceProgressCount > compareCar.raceProgressCount;
    }

    public boolean hasSameProgress(RacingCar compareCar) {
        return this.raceProgressCount == compareCar.raceProgressCount;
    }

    public String getName() {
        return carName;
    }

    public int getProgress() {
        return raceProgressCount;
    }
}