package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> names;

    public CarNames(String names) throws IllegalArgumentException {
        List<String> namesList = splitNames(names);
        for (String name : namesList) {
            if (!validateName(name)) {
                throw new IllegalArgumentException("입력값의 길이가 5 이상이거나 공백을 포함하고 있습니다.");
            }
        }
        this.names = namesList.stream().map(s -> new CarName(s)).collect(Collectors.toList());

    }

    public List<CarName> getNames() {
        return names;
    }

    public List<String> splitNames(String names) {
        String[] namesArr = names.split(",");
        List<String> nameList = new ArrayList<>();
        for (String name : namesArr) {
            nameList.add(name);
        }
        return nameList;
    }


    private boolean validateName(String name) {
        if ((name.length() > 5 || name.contains(" ")) || name.length() == 0) {
            return false;
        }
        return true;
    }

}
