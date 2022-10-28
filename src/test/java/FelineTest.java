import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private String animalSpecies;
    private List expectedFood;

    public FelineTest(String animalSpecies, List expectedFood) {
        this.animalSpecies = animalSpecies;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошачьи такого не едят!", expectedFood, feline.eatMeat());
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(animalSpecies + " такое не ест!", expectedFood, feline.getFood(animalSpecies));
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensReturnsOneTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());

    }

    @Test
    public void getKittensReturnsCountTest() {
        Feline feline = new Feline();
        Assert.assertEquals(5, feline.getKittens(5));
    }
}
