import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Before
    public void init () throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

    }
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Это не кошачья еда!",cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void getSoundTest(){
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кошки говорят Мяу, а не вот это вот всё!","Мяу",cat.getSound());
    }
}
