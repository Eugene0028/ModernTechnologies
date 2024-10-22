package io.eugene.tpnumber;

public class PNumber extends TPNumber {

    public PNumber(double value, int base, int precision) {
        super(value, base, precision);
    }

    public PNumber(String value, String base, String precision) {
        super(value, base, precision);
    }

    @Override
    public TPNumber add(TPNumber d) {
        if (!(d instanceof PNumber)) {
            throw new IllegalArgumentException("Operands must be of type PNumber");
        }
        PNumber pNumberD = (PNumber) d;
        if (base != pNumberD.base || precision != pNumberD.precision) {
            throw new IllegalArgumentException("Bases and precisions must match");
        }
        double resultValue = number + pNumberD.number;
        return new PNumber(resultValue, base, precision);
    }

    @Override
    public TPNumber subtract(TPNumber d) {
        if (!(d instanceof PNumber)) {
            throw new IllegalArgumentException("Operands must be of type PNumber");
        }
        PNumber pNumberD = (PNumber) d;
        if (base != pNumberD.base || precision != pNumberD.precision) {
            throw new IllegalArgumentException("Bases and precisions must match");
        }
        double resultValue = number - pNumberD.number;
        return new PNumber(resultValue, base, precision);
    }

    @Override
    public TPNumber multiply(TPNumber d) {
        if (!(d instanceof PNumber)) {
            throw new IllegalArgumentException("Operands must be of type PNumber");
        }
        PNumber pNumberD = (PNumber) d;
        if (base != pNumberD.base || precision != pNumberD.precision) {
            throw new IllegalArgumentException("Bases and precisions must match");
        }
        double resultValue = number * pNumberD.number;
        return new PNumber(resultValue, base, precision);
    }

    @Override
    public TPNumber divide(TPNumber d) {
        if (!(d instanceof PNumber)) {
            throw new IllegalArgumentException("Operands must be of type PNumber");
        }
        PNumber pNumberD = (PNumber) d;
        if (base != pNumberD.base || precision != pNumberD.precision) {
            throw new IllegalArgumentException("Bases and precisions must match");
        }
        if (pNumberD.number == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        double resultValue = number / pNumberD.number;
        return new PNumber(resultValue, base, precision);
    }



    @Override
    public TPNumber invert() {
        if (number == 0.0) {
            throw new ArithmeticException("Cannot invert zero");
        }
        double resultValue = 1.0 / number;
        return new PNumber(resultValue, base, precision);
    }

    @Override
    public TPNumber square() {
        double resultValue = number * number;
        return new PNumber(resultValue, base, precision);
    }
}

