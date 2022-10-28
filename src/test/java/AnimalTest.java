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
        };
    }
   @Test //(expected = Exception.class)
    public void getFoodValidTest() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(expectedFood, animal.getFood(animalKind));
    }

    @Test
    public void getFoodThrowsExceptionTest() {
        Animal animal = new Animal();
        Exception exception = null;
        try {
            List animalFood  = animal.getFood("Чужой");
        } catch (Exception ex) {
            exception = ex;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, animal.getFamily());
    }

}
