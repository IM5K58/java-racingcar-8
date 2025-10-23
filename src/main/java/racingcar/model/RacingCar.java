package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class RacingCar {
    private final String carName;
    private int raceProgressCount;

    static final int RANGE_START = 0;
    static final int RANGE_END = 9;
    static final int RANGE_LIMIT = 4;
    static final int MOVE_VALUE = 1;
    static final String MOVE_SIGN = "-";

    public RacingCar(String carName){
        //if(!carName 검증) throw IllegalArgumentException("자동차 이름이 잘못 설정 되었습니다.");
        this.carName = carName;
        raceProgressCount = 0;
    }

    public void race(){
        int randomNum = Randoms.pickNumberInRange(RANGE_START,RANGE_END);
        if(randomNum >= RANGE_LIMIT){
            raceProgressCount += MOVE_VALUE;
        }
    }

    public void raceResult(){
        System.out.print(carName + " : ");
        System.out.println(MOVE_SIGN.repeat(raceProgressCount));
    }
}

//책임 분리 필요. 코드 완성 후 수정