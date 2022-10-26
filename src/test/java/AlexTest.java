import com.example.Alex;
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
public class AlexTest {
    @Mock
    Feline feline;
    @Before
    public void init () throws Exception {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

    }
    @Test
    public void alexDoesHaveManeTest () throws Exception {
        Alex alex = new Alex(feline);
        Assert.assertTrue("У Алекса есть грива!",alex.doesHaveMane());
    }

    @Test
    public void getFriendsTest() throws Exception {
        Alex alex = new Alex(feline);
        List expectedFriends =  List.of("Мартин", "Глория", "Мелман");
        Assert.assertEquals("Это не друзья Алекса!", expectedFriends,alex.getFriends());
    }
    @Test
    public void getPlaceOfLivingTest() throws Exception {
        Alex alex = new Alex(feline);
        String expectedPlaceLiving = "Нью-Йоркский зоопарк";
        Assert.assertEquals("Алекс здесь не живет!",expectedPlaceLiving,alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensTest() throws Exception {
        Alex alex = new Alex(feline);
        Assert.assertEquals("У Алекса нет котят!",alex.getKittens(),0);
    }
    @Test
    public void getFoodTest() throws Exception {
        Alex alex = new Alex(feline);
        List expectedListFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Нет, такое Алекс не ест!",expectedListFood,alex.getFood());
    }

    @Test
    public void getFamilyTest() throws Exception {
        Alex alex = new Alex(feline);
        String expectedResult = "Кошачьи";
        Assert.assertEquals("Семейство не относится к Кошачьим",expectedResult,alex.getFamily());
    }
}
