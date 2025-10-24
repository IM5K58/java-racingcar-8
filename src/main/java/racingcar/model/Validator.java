package racingcar.model;

import java.util.HashSet;

public class Validator {
    private final static int LENGTH_MAX = 5;

    public void validate(HashSet<String>names){
        for(String name : names){
            if(name.length() > LENGTH_MAX){
                throw new IllegalArgumentException("자동차 이름이 너무 깁니다.");
            }
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳과 숫자로만 구성되어야 합니다.");
            }
        }

    }
}
