import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testBlank() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(0,calc.add(""));
    }
    @Test
    public void testOneNumber() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(5,calc.add("5"));
    }
    @Test
    public void testTwoNumber()  throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("-2,3"));
    }
    @Test
    public void testTwoNumber2() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(5, calc.add("2,3"));
    }
    @Test
    public void testFiveNumber() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(12, calc.add("2,3,1,5,1"));
    }
    @Test
    public void testFiveNumber2()  throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(10,calc.add("2,3,-1,5,1"));
    }
    @Test
    public void testSixNumber() throws Exception{
        StringCalculator calc = new StringCalculator();
         assertEquals(1,calc.add("1\n2,-2"));
    }
    @Test
    public void testSixNumber2() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    public void testSevenNumber() throws Exception{
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void testCustomSeperator () throws Exception {
        StringCalculator calc = new StringCalculator();
            assertEquals(3, calc.add("//;\n1;2"));

    }
    @Test
    public void testCustomSeperator2() throws Exception {
        StringCalculator calc = new StringCalculator();
        assertEquals(1,calc.add("//*\n-1*2"));
    }
    @Test
    public void testNegativeNumbers() throws Exception {
        StringCalculator calc = new StringCalculator();
        Exception ex = assertThrows( NegativeNumberException.class,()->{calc.add("-1,2");});
        assertEquals("Numbers must be non-negative: -1", ex.getMessage());

    }
    @Test
    public void testNegativeNumber() throws Exception {
        StringCalculator calc = new StringCalculator();
        Exception ex = assertThrows( NegativeNumberException.class,()->{calc.add("-1");});
        assertEquals("Number must be non-negative: -1 ", ex.getMessage());

    }
    @Test
    public void testNegativeNumbers2() throws Exception {
        StringCalculator calc = new StringCalculator();
        Exception ex = assertThrows( NegativeNumberException.class,()->{calc.add("//*\n-1*-2");});
        assertEquals("Numbers must be non-negative: -1 -2 ", ex.getMessage());

    }
    @Test
    public void testIgnores1000() throws Exception {
        StringCalculator calc = new StringCalculator();
        assertEquals(1999, calc.add("1000,999,1001"));
    }

}


