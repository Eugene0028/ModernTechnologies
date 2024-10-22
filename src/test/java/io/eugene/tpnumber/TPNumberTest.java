package io.eugene.tpnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TPNumberTest {

    @Test
    public void testConstructorDoubleBasePrecision() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        assertEquals(10.0, num1.getNumber());
        assertEquals(10, num1.getBase());
        assertEquals(2, num1.getPrecision());

        PNumber num2 = new PNumber(234.153, 5, 8);
        assertEquals("1414.03403030", num2.getNumberString());
        assertEquals(5, num2.getBase());
        assertEquals(8, num2.getPrecision());
    }

    @Test
    public void testConstructorDoubleBasePrecisionExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new PNumber(10.0, 20, 2));
        assertThrows(IllegalArgumentException.class, () -> new PNumber(10.0, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> new PNumber(10.0, 6, -1));
    }

    @Test
    public void testConstructorStringBasePrecisionExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new PNumber("10.0", "20", "2"));
        assertThrows(IllegalArgumentException.class, () -> new PNumber("10.0", "1", "2"));
        assertThrows(IllegalArgumentException.class, () -> new PNumber("10.0", "6", "-1"));
        assertThrows(IllegalArgumentException.class, () -> new PNumber("1~0.0", "6", "1"));
        assertThrows(IllegalArgumentException.class, () -> new PNumber("10.0", "Z", "2"));
    }

    @Test
    public void testConstructorStringBasePrecision() {
        PNumber num2 = new PNumber("-A.B9", "16", "4");
        assertEquals(-10.7227, num2.getNumber(), 0.0001);
        assertEquals(16, num2.getBase());
        assertEquals(4, num2.getPrecision());
    }

    @Test
    public void testSetBaseFromInt() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        num1.setBase(2);
        assertEquals(2, num1.getBase());
    }


    @Test
    public void testSetBaseFromString() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        num1.setBase(8);
        assertEquals(8, num1.getBase());
    }


    @Test
    public void testSetPrecisionFromInt() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        num1.setPrecision(4);
        assertEquals(4, num1.getPrecision());
    }

    @Test
    public void testSetPrecisionFromIntExceptions() {
        PNumber num1 = new PNumber("10.0", "3", "2");
        assertThrows(IllegalArgumentException.class, () -> num1.setPrecision(-1));
    }

    @Test
    public void testSetPrecisionFromString() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        num1.setPrecision(5);
        assertEquals(5, num1.getPrecision());
    }

    @Test
    public void testAddition() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(20.0, 10, 2);
        PNumber result = (PNumber) num1.add(num4);
        assertEquals(30.0, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testOperationsExceptionsBase() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(20.0, 12, 2);
        assertThrows(IllegalArgumentException.class, () -> num1.add(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.subtract(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.multiply(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.divide(num4));
    }

    @Test
    public void testOperationsExceptionsPrecision() {
        PNumber num1 = new PNumber(10.0, 10, 4);
        PNumber num4 = new PNumber(20.0, 10, 2);
        assertThrows(IllegalArgumentException.class, () -> num1.add(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.subtract(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.multiply(num4));
        assertThrows(IllegalArgumentException.class, () -> num1.divide(num4));
    }

    @Test
    public void testDivisionByZero() {
        PNumber num1 = new PNumber(10.0, 10, 4);
        PNumber num4 = new PNumber(0.0, 10, 4);
        assertThrows(ArithmeticException.class, () -> num1.divide(num4));
    }

    @Test
    public void testSubtraction() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(20.0, 10, 2);
        PNumber result = (PNumber) num4.subtract(num1);
        assertEquals(10.0, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testMultiplication() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(20.0, 10, 2);
        PNumber result = (PNumber) num1.multiply(num4);
        assertEquals(200.0, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testDivision() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(20.0, 10, 2);
        PNumber result = (PNumber) num4.divide(num1);
        assertEquals(2.0, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testInvert() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        TPNumber result = num1.invert();
        assertEquals(0.1, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testInvertException() {
        PNumber num1 = new PNumber(0.0, 10, 2);
        assertThrows(ArithmeticException.class, () -> num1.invert());
    }

    @Test
    public void testSquare() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        TPNumber result = num1.square();
        assertEquals(100.0, result.getNumber());
        assertEquals(10, result.getBase());
        assertEquals(2, result.getPrecision());
    }

    @Test
    public void testDivisionByZeroRef() {
        PNumber num1 = new PNumber(10.0, 10, 2);
        PNumber num4 = new PNumber(0.0, 10, 2);
        assertThrows(ArithmeticException.class, () -> num1.divide(num4));
    }
}
