package com.example.mycalculator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String twoPlusTwo = MathEval.eval("2+2");
        assertEquals("4", twoPlusTwo);

        String decimalAddition = MathEval.eval("6.4+7.3");
        assertEquals("13.7", decimalAddition);

        String decimalWholeAdd = MathEval.eval("2.5+2.5");
        assertEquals("5", decimalWholeAdd);

        String negativeAddition = MathEval.eval("-4+7");
        assertEquals("3", negativeAddition);

        String negativeResult = MathEval.eval("-10+-2");
        assertEquals("-12", negativeResult);
    }

    public void subtraction_isCorrect() {
        String regularInts = MathEval.eval("5-3");
        assertEquals("2", regularInts);
        String decimalSubtraction = MathEval.eval("11-6.75");
        assertEquals("4.25", decimalSubtraction);
        String decimalWholeSubtraction = MathEval.eval("7.5-4.5");
        assertEquals("3", decimalWholeSubtraction);
        String negativeResult = MathEval.eval("4-8");
        assertEquals("-4", negativeResult);
    }

    public void multiplication_isCorrect() {
        String regularMultiplication = MathEval.eval("5*4");
        assertEquals("20", regularMultiplication);

        String decimalMultiplication = MathEval.eval("6*1.5");
        assertEquals("9", decimalMultiplication);

        String decimalResult = MathEval.eval("2.5*3");
        assertEquals("7.5", decimalResult);

        String negativeMultiplication = MathEval.eval("-8*5");
        assertEquals("-40", negativeMultiplication);

        String doubleNegative = MathEval.eval("-3*-9");
        assertEquals("27", doubleNegative);

        String negativeAndDecimal = MathEval.eval("-7*2.5");
        assertEquals("-17.5", negativeAndDecimal);
    }

    public void division_isCorrect() {
        String regularDivision = MathEval.eval("6/3");
        assertEquals("2", regularDivision);

        String decimalDivision = MathEval.eval("12/0.5");
        assertEquals("24", decimalDivision);

        String decimalResult = MathEval.eval("9/2");
        assertEquals("4.5", decimalResult);

        String negativeResult = MathEval.eval("8/-4");
        assertEquals("-2", negativeResult);

        String doubleNegative = MathEval.eval("-9/-3");
        assertEquals("3", doubleNegative);

        String negativeAndDecimal = MathEval.eval("-2/-0.25");
        assertEquals("8", negativeAndDecimal);
    }
}