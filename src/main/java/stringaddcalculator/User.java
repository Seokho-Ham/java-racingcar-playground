package stringaddcalculator;

import java.util.Scanner;

public class User {
    private static final Scanner sc = new Scanner(System.in);

    public String getInput(){
        System.out.println("숫자를 입력해주세요.");
        return sc.nextLine();
    }
}
