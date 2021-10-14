package stringaddcalculator;

import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(Object o) throws RuntimeException{
        if(o == null || ((String)o).isEmpty()){
            return 0;
        }
        String input = (String)o;

        if(input.length()==1 && isNumber(input)){
            return Integer.parseInt(input);
        }

        List<Integer> numbers = Spliter.splitInput(input);
        int result = 0;
        for(int num : numbers){
            result += num;
        }
        return result;
    }



    private static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
