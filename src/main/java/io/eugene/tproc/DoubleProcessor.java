package io.eugene.tproc;

public class DoubleProcessor extends Processor<Double> {

    public DoubleProcessor(Double defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    protected Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    protected Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    protected Double divide(Double a, Double b) throws ArithmeticException {
        return a / b;
    }

    @Override
    protected Double negative(Double a) {
        return -a;
    }
}
