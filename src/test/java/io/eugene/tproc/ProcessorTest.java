package io.eugene.tproc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProcessorTest {

    private IntegerProcessor integerProcessor;
    private DoubleProcessor doubleProcessor;

    @BeforeEach
    public void setUp() {
        integerProcessor = new IntegerProcessor(0);
        doubleProcessor = new DoubleProcessor(0.0);
    }

    // Тесты для IntegerProcessor
    @Test
    public void testIntegerAddition() {
        integerProcessor.setLopRes(5);
        integerProcessor.setRop(3);
        integerProcessor.setOperation(TOprtn.ADD);
        integerProcessor.runOperation();
        assertEquals(8, integerProcessor.readLopRes());
    }

    @Test
    public void testIntegerSubtraction() {
        integerProcessor.setLopRes(5);
        integerProcessor.setRop(3);
        integerProcessor.setOperation(TOprtn.SUB);
        integerProcessor.runOperation();
        assertEquals(2, integerProcessor.readLopRes());
    }

    @Test
    public void testIntegerMultiplication() {
        integerProcessor.setLopRes(5);
        integerProcessor.setRop(3);
        integerProcessor.setOperation(TOprtn.MUL);
        integerProcessor.runOperation();
        assertEquals(15, integerProcessor.readLopRes());
    }

    @Test
    public void testIntegerDivision() {
        integerProcessor.setLopRes(6);
        integerProcessor.setRop(3);
        integerProcessor.setOperation(TOprtn.DVD);
        integerProcessor.runOperation();
        assertEquals(2, integerProcessor.readLopRes());
    }

    @Test
    public void testIntegerDivisionByZero() {
        integerProcessor.setLopRes(6);
        integerProcessor.setRop(0);
        integerProcessor.setOperation(TOprtn.DVD);
        assertThrows(ArithmeticException.class, integerProcessor::runOperation);
    }

    @Test
    public void testIntegerNegative() {
        integerProcessor.setRop(5);
        integerProcessor.runFunction(TFunc.REV);
        assertEquals(-5, integerProcessor.readRop());
    }

    @Test
    public void testIntegerSquare() {
        integerProcessor.setRop(3);
        integerProcessor.runFunction(TFunc.SQR);
        assertEquals(9, integerProcessor.readRop());
    }

    // Тесты для DoubleProcessor
    @Test
    public void testDoubleAddition() {
        doubleProcessor.setLopRes(5.5);
        doubleProcessor.setRop(3.3);
        doubleProcessor.setOperation(TOprtn.ADD);
        doubleProcessor.runOperation();
        assertEquals(8.8, doubleProcessor.readLopRes(), 0.001);
    }

    @Test
    public void testDoubleSubtraction() {
        doubleProcessor.setLopRes(5.5);
        doubleProcessor.setRop(3.3);
        doubleProcessor.setOperation(TOprtn.SUB);
        doubleProcessor.runOperation();
        assertEquals(2.2, doubleProcessor.readLopRes(), 0.001);
    }

    @Test
    public void testDoubleMultiplication() {
        doubleProcessor.setLopRes(5.5);
        doubleProcessor.setRop(3.3);
        doubleProcessor.setOperation(TOprtn.MUL);
        doubleProcessor.runOperation();
        assertEquals(18.15, doubleProcessor.readLopRes(), 0.001);
    }

    @Test
    public void testDoubleDivision() {
        doubleProcessor.setLopRes(6.6);
        doubleProcessor.setRop(3.3);
        doubleProcessor.setOperation(TOprtn.DVD);
        doubleProcessor.runOperation();
        assertEquals(2.0, doubleProcessor.readLopRes(), 0.001);
    }

    @Test
    public void testDoubleDivisionByZero() {
        doubleProcessor.setLopRes(6.6);
        doubleProcessor.setRop(0.0);
        doubleProcessor.setOperation(TOprtn.DVD);
        doubleProcessor.runOperation();
        assertEquals(Double.POSITIVE_INFINITY, doubleProcessor.readLopRes());
    }

    @Test
    public void testDoubleNegative() {
        doubleProcessor.setRop(5.5);
        doubleProcessor.runFunction(TFunc.REV);
        assertEquals(-5.5, doubleProcessor.readRop(), 0.001);
    }

    @Test
    public void testDoubleSquare() {
        doubleProcessor.setRop(3.3);
        doubleProcessor.runFunction(TFunc.SQR);
        assertEquals(10.89, doubleProcessor.readRop(), 0.001);
    }
}

