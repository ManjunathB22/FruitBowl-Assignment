import java.util.Arrays;
import java.util.List;

public class FruitsBowl {

    private List<Fruit> fruitList;

    public FruitsBowl(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public FruitsBowl() {
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void addFruitsToMixedFruitsBowl(Fruit... fruits){
        fruitList = Arrays.asList(fruits);
    }


}
