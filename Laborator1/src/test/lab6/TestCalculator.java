package test.lab6;

import lab6.DoubleCalculator;
import lab6.NewIntCalculator;
import org.junit.jupiter.api.*;

public class TestCalculator
{
    private NewIntCalculator intCalc;
    private DoubleCalculator doubleCalc;

    @BeforeEach
    public void setup()
    {
        NewIntCalculator intCalc = new NewIntCalculator(0);
        //int calcDouble = new DoubleCalculator(0.0);
    }

    @Test
    public void testAddPositive()
    {
        intCalc.init(5);
        intCalc.add(10);
        Assertions.assertEquals(15, intCalc.result());
    }

    @Test
    public void testAddNegative()
    {
        intCalc.init(5);
        intCalc.add(20);
        Assertions.assertEquals(-10, intCalc.result());
    }
}
