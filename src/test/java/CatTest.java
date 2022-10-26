import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CatTest {
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(new Feline());
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void getSoundTest(){

        Cat cat = new Cat(new Feline());
        Assert.assertEquals(cat.getSound(), "Мяу");

    }
}
