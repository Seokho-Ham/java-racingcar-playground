package stringaddcalculator;

import java.util.ArrayList;
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
        Stream<String> resultStream = Arrays.stream(m.group(2).split(customDelimiter));
        if(hasNegativeNumber(resultStream) | hasNotNumber(resultStream)){
            throw new RuntimeException();
        }
        List<Integer> result = resultStream.map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return result;
    }

    private static List<Integer> splitByDefaultDelimiter(String input) throws RuntimeException {
        List<Integer> result;
        Stream<String> resultStream = Arrays.stream(input.split(",|:"));
        if(hasNegativeNumber(resultStream) | hasNotNumber(resultStream)){
            throw new RuntimeException();
        }
        result = resultStream.map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return result;
    }

    private static boolean hasNegativeNumber(Stream<String> st){
        return st.map(s->Integer.parseInt(s)).anyMatch(s->s<0);
    }

    private static boolean hasNotNumber(Stream<String> st){

        return st.anyMatch(s->!isInteger(s));
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
