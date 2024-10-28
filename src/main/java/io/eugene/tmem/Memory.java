package io.eugene.tmem;

import java.math.BigInteger;

public abstract class Memory<T extends Number> {
    T FNumber;
    State FState;

    public Memory(T FNumber) {
        this.FNumber = FNumber;
        this.FState = State.OFF;
    }

    public void write(T E) {
        this.FNumber = E;
        FState = State.ON;
    }

    public T getFNumber() {
        FState = State.ON;
        return FNumber;
    }

    protected abstract T addTwoNumbers(Number value);

    public void add(T E) {
        FNumber = addTwoNumbers(FNumber.doubleValue() + E.doubleValue());
        FState = State.ON;
    }


    protected abstract T getDefaultValue();
    public void clean() {
        FState = State.OFF;
        FNumber = getDefaultValue();
    }

    public String readMemoryState() {
        return FState.toString();
    }

    public String readNumber() {
        return FNumber.toString();
    }

    public enum State {
        ON(true),
        OFF(false);

        State(boolean b) {
        }
    }
}
