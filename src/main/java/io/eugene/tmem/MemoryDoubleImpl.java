package io.eugene.tmem;

public class MemoryDoubleImpl extends Memory<Double> {
    public MemoryDoubleImpl(Double FNumber) {
        super(FNumber);
    }

    @Override
    public Double addTwoNumbers(Number value) {
        return value.doubleValue();
    }

    @Override
    protected Double getDefaultValue() {
        return 0.0;
    }
}
