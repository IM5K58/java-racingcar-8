package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;

public class Separator {
    private static final String SPLIT_SIGN = ",";

    public HashSet<String> splitAndReturn(String input){
        String[] names = input.split(SPLIT_SIGN);
        HashSet<String> carNames = new HashSet<>();
        carNames.addAll(Arrays.asList(names));
        return carNames;
    }
}
