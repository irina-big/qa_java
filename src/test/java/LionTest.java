import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)

public class LionTest {
    Feline feline;
    String sexLion;
    boolean hasManeResult;
    public LionTest( String sexLion, boolean hasManeResult){
        this.sexLion = sexLion;
        this.hasManeResult = hasManeResult;
    }
   @Parameterized.Parameters
    public static Object[][] getParameters() {
       return new Object[][]{
               {"Самец", true} ,
               {"Самка", false} //,
               //{"Чужой-Другой", ""}
       };
   }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Mockito.when(feline.getKittens(5)).thenReturn(5);

    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion  = new Lion(sexLion, feline);
        Assert.assertEquals(lion.doesHaveMane(), hasManeResult);
    }

    @Test
    public void getKittensOneTest() throws Exception {
        Lion lion  = new Lion(sexLion, feline);
        Assert.assertEquals(lion.getKittens(),1);
    }
    @Test
    public void getKittensCountTest() throws Exception {
        Lion lion  = new Lion(sexLion, feline);
        Assert.assertEquals(lion.getKittens(5),5);
    }
}
