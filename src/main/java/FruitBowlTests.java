import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitBowlTests {

    Fruit apple, banana, grape, orange, apple2, apple3;

    @BeforeTest
    public void setUpTestData() {
         apple = new Fruit("Apple", "red", "large");
         banana = new Fruit("Banana", "yellow", "medium");
         grape = new Fruit("Grape", "green", "small");
         orange = new Fruit("Orange", "orange", "medium");
         apple2 = new Fruit("Apple", "red", "large");
         apple3 = new Fruit("Apple", "red", "small");
    }

    @Test
    public void testSortFruitsByName() {
        FruitsBowl mixedFruitsBowl = new FruitsBowl();
        mixedFruitsBowl.addFruitsToMixedFruitsBowl(apple, banana, grape, orange, apple2, apple3);
        FruitSegregator segregator = new FruitSegregator();


        List<FruitsBowl> sortedFruitBowlsForBasketStand = segregator.getSegregatedFruitsToIndividualBowl(mixedFruitsBowl, "name");  //getting list of sorted fruits with sorting type

        FruitBasketStand fruitBasket = new FruitBasketStand(sortedFruitBowlsForBasketStand); // adding all the segregated fruit bowls to fruit basket
        fruitBasket.showFruitBasket();

        int fruitsByName= fruitBasket.getFruitsBowlList().stream().findFirst().get().getFruitList().stream().map(Fruit::getName).collect(Collectors.toList()).size();
        Assert.assertEquals(fruitsByName,3);

    }

    @Test
    public void testSortFruitsByColor() {
        FruitsBowl mixedFruitsBowl = new FruitsBowl();
        mixedFruitsBowl.addFruitsToMixedFruitsBowl(apple, banana, grape, orange, apple2, apple3);
        FruitSegregator segregator = new FruitSegregator();

        List<FruitsBowl> sortedFruitBowlsForBasketStand = segregator.getSegregatedFruitsToIndividualBowl(mixedFruitsBowl, "color");  //getting list of sorted fruits with sorting type

        FruitBasketStand fruitBasket = new FruitBasketStand(sortedFruitBowlsForBasketStand);

        fruitBasket.showFruitBasket();

        int numberOfFruitOfColorOrange= fruitBasket.getFruitsBowlList().stream().findFirst().get().getFruitList().stream().map(Fruit::getColor).collect(Collectors.toList()).size();

        Assert.assertEquals(numberOfFruitOfColorOrange,1);

    }

    @Test
    public void testSortFruitsBySize() {
        FruitsBowl mixedFruitsBowl = new FruitsBowl();
        mixedFruitsBowl.addFruitsToMixedFruitsBowl(apple, banana, grape, orange, apple2, apple3);
        FruitSegregator segregator = new FruitSegregator();

        List<FruitsBowl> sortedFruitBowlsForBasketStand = segregator.getSegregatedFruitsToIndividualBowl(mixedFruitsBowl, "size");  //getting list of sorted fruits with sorting type

        FruitBasketStand fruitBasket = new FruitBasketStand(sortedFruitBowlsForBasketStand);

        fruitBasket.showFruitBasket();

        int numberOfFruitOfSizeSmall = fruitBasket.getFruitsBowlList().stream().findFirst().get().getFruitList().stream().map(Fruit::getSize).collect(Collectors.toList()).size();

        Assert.assertEquals(numberOfFruitOfSizeSmall,2);

    }

    @Test
    public void testFruitsDoNotSortWithOtherTypes() {
        FruitsBowl mixedFruitsBowl = new FruitsBowl();
        mixedFruitsBowl.addFruitsToMixedFruitsBowl(apple, banana, grape, orange, apple2, apple3);
        FruitSegregator segregator = new FruitSegregator();
        Map<String, List<Fruit>> sortFruits = segregator.sortFruits(mixedFruitsBowl, "other");
        Assert.assertEquals(sortFruits,null,"Fruits can only be sorted by type - color , size , name");
    }


}
