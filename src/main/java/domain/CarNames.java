package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> names;

    public CarNames(String names) throws IllegalArgumentException {
        List<String> namesList = splitNames(names);

        this.names = namesList.stream().map(s -> new CarName(s)).collect(Collectors.toList());

    }

    public List<CarName> getNames() {
        return names;
    }

    public static List<String> splitNames(String names) {
        String[] namesArr = names.split(",");
        List<String> nameList = new ArrayList<>();
        for (String name : namesArr) {
            nameList.add(name);
        }
        return nameList;
    }

    public static boolean validateCarNames(String names) {
        List<String> namesList = splitNames(names);
        for (String name : namesList) {
            if ((name.length() > 5 || name.contains(" ")) || name.length() == 0) {
                return false;
            }
        }
        return true;
    }

}
