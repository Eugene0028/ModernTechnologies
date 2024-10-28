package io.eugene.tproc;

public class IntegerProcessor extends Processor<Integer> {

    public IntegerProcessor(Integer defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    protected Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    protected Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    protected Integer divide(Integer a, Integer b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }

    @Override
    protected Integer negative(Integer a) {
        return -a;
    }

}
