import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testBlank(){
        StringCalculator calc = new StringCalculator();
        assertEquals(0,calc.add(""));
    }
    @Test
    public void testOneNumber(){
        StringCalculator calc = new StringCalculator();
        assertEquals(5,calc.add("5"));
    }
}


