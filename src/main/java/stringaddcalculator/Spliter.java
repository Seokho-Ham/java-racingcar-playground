package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spliter {

    public static List<Integer> splitInput(String input) throws RuntimeException{
        if(input.contains("//")){
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiter(input);
    }

    private static List<Integer> splitByCustomDelimiter(String input) throws RuntimeException{
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        m.find();
        String customDelimiter = m.group(1);
        if(hasNegativeNumber(Arrays.stream(m.group(2).split(customDelimiter)))){
            throw new RuntimeException();
        }
        List<Integer> result = Arrays.stream(m.group(2).split(customDelimiter)).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return result;
    }

    private static List<Integer> splitByDefaultDelimiter(String input) throws RuntimeException {
        List<Integer> result;
        if(hasNegativeNumber(Arrays.stream(input.split(",|:")))){
            throw new RuntimeException();
        }
        result = Arrays.stream(input.split(",|:")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return result;
    }

    private static boolean hasNegativeNumber(Stream<String> st){
        return st.anyMatch(s->(!isInteger(s) || Integer.parseInt(s)<0));
    }



    private static boolean isInteger(String s){
        if(s.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;

    }
}
