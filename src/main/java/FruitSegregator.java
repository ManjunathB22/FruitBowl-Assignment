import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitSegregator {

    private Map<String, List<Fruit>> sortedFruits;

    public Map<String, List<Fruit>> sortFruits(FruitsBowl mixedFruitsBowl, String sortType) {
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



    public List<FruitsBowl> getSegregatedFruitsToIndividualBowl(FruitsBowl mixedFruitsBowl, String sortType){
        sortedFruits = sortFruits(mixedFruitsBowl, sortType);
        List<FruitsBowl> sortedFruitBowlsForBasketStand = new ArrayList<>();
        sortedFruits.values().stream().forEach(value -> sortedFruitBowlsForBasketStand.add(new FruitsBowl(value))); //setting all the sorted fruits to individual fruit bowls
        return sortedFruitBowlsForBasketStand;
    }

}
