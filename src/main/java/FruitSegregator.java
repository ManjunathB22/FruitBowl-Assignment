import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitSegregator {

    public Map<String, List<Fruit>> sortFruits(FruitsBowl mixedFruitsBowl, String sortType) {
        Map<String, List<Fruit>> sortedFruits;
        switch (sortType) {

            case "color":
                sortedFruits = mixedFruitsBowl.getFruitList().stream()
                        .collect(Collectors.groupingBy(Fruit::getColor,
                                Collectors.toList()));

                break;
            case "name":
                sortedFruits = mixedFruitsBowl.getFruitList().stream()
                        .collect(Collectors.groupingBy(Fruit::getName,
                                Collectors.toList()));

                break;
            case "size":
                sortedFruits = mixedFruitsBowl.getFruitList().stream()
                        .collect(Collectors.groupingBy(Fruit::getSize,
                                Collectors.toList()));

                break;
            default:
                sortedFruits = null;
                break;
        }
        return sortedFruits;
    }
}
