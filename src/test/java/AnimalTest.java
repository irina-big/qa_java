import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)

public class AnimalTest {
    String animalKind;
    List expectedFood;

    public AnimalTest(String animalKind,   List expectedFood){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник",     List.of("Животные", "Птицы", "Рыба")}
                //{"Другой-Чужой",""}
        };
    }
   @Test //(expected = Exception.class)
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(expectedFood, animal.getFood(animalKind));
    }

    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, animal.getFamily());
    }

}
