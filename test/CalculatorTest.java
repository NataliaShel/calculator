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
    @Test
    public void testTwoNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("-2,3"));
    }
    @Test
    public void testTwoNumber2() {
        StringCalculator calc = new StringCalculator();
        assertEquals(5, calc.add("2,3"));
    }
    @Test
    public void testFiveNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(12, calc.add("2,3,1,5,1"));
    }
    @Test
    public void testFiveNumber2() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("2,3,-1,5,1"));
    }
    @Test
    public void testSixNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1\n2,-2"));
    }
    @Test
    public void testSixNumber2() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    public void testSevenNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void testCustomSeperator() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    public void testCustomSeperator2() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("//*\n-1*2"));
    }

}


