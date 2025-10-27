package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String inputName(){
        return Console.readLine();
    }

    public int inputTrials(){
        return Integer.parseInt(Console.readLine());
    }

}
