package io.eugene.tmem;

public class MemoryIntImpl extends Memory<Integer> {
    public MemoryIntImpl(Integer FNumber) {
        super(FNumber);
    }


    @Override
    public Integer addTwoNumbers(Number value) {
        return value.intValue();
    }

    @Override
    protected Integer getDefaultValue() {
        return 0;
    }
}
