import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FruitBasketStand {
    private List<FruitsBowl> fruitsBowlList;

    public List<FruitsBowl> getFruitsBowlList() {
        return fruitsBowlList;
    }

    public FruitBasketStand(List<FruitsBowl> fruitsBowlList) {
        this.fruitsBowlList = fruitsBowlList;
    }

    public void showFruitBasket()
    {
        IntStream.range(0, fruitsBowlList.size())
                .mapToObj(index -> String.format("%d -> %s",
                        index,fruitsBowlList.get(index).getFruitList()
                                        .stream().map(Fruit::getName).collect(Collectors.joining(", "))))

                .forEach(System.out::println);
    }

}
