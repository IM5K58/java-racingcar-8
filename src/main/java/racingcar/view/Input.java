package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String input_name(){
        return Console.readLine();
    }

    public int input_trials(){
        return Integer.parseInt(Console.readLine());
    }

}
