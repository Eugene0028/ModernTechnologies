package io.eugene.tpnumber;

public abstract class TPNumber {

    protected double number;
    protected int base;
    protected int precision;
    protected String numberString;

    public TPNumber(double value, int base, int precision) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be in the range [2..16]");
        }
        if (precision < 0) {
            throw new IllegalArgumentException("Precision must be non-negative");
        }
        this.number = value;
        this.base = base;
        this.precision = precision;
        this.numberString = convertToBase(value, base, precision);
    }

    public TPNumber(String value, String base, String precision) {
        try {
            this.base = Integer.parseInt(base);
            this.precision = Integer.parseInt(precision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid base or precision");
        }
        if (this.base < 2 || this.base > 16) {
            throw new IllegalArgumentException("Base must be in the range [2..16]");
        }
        if (this.precision < 0) {
            throw new IllegalArgumentException("Precision must be non-negative");
        }
        this.number = stringToDouble(value, this.base);
        this.numberString = value;
    }

    public abstract TPNumber add(TPNumber d);
    public abstract TPNumber subtract(TPNumber d);
    public abstract TPNumber multiply(TPNumber d);
    public abstract TPNumber divide(TPNumber d);

    public abstract TPNumber invert();
    public abstract TPNumber square();

    protected String convertToBase(double value, int base, int precision) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be in the range [2..16]");
        }

        boolean isNegative = value < 0;
        value = Math.abs(value);

        // Разделяем на целую и дробную часть
        long integerPart = (long) value;
        double fractionalPart = value - integerPart;

        // Конвертация целой части
        StringBuilder integerString = new StringBuilder();
        if (integerPart == 0) {
            integerString.append('0');
        } else {
            while (integerPart > 0) {
                long remainder = integerPart % base;
                integerString.insert(0, getBaseDigit(remainder));
                integerPart /= base;
            }
        }

        // Конвертация дробной части
        StringBuilder fractionalString = new StringBuilder();
        if (precision > 0) {
            fractionalString.append('.');
            for (int i = 0; i < precision; i++) {
                fractionalPart *= base;
                int fractionalDigit = (int) fractionalPart;
                fractionalString.append(getBaseDigit(fractionalDigit));
                fractionalPart -= fractionalDigit;
            }
        }

        // Собираем итоговую строку
        if (isNegative) {
            integerString.insert(0, '-');
        }

        return integerString + fractionalString.toString();
    }

    private char getBaseDigit(long digit) {
        if (digit >= 0 && digit <= 9) {
            return (char) ('0' + digit);
        } else {
            return (char) ('A' + (digit - 10));
        }
    }


    protected double stringToDouble(String value, int base) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be in the range [2..16]");
        }

        boolean isNegative = value.startsWith("-");
        if (isNegative) {
            value = value.substring(1);
        }

        String[] parts = value.split("\\.");
        double integerPart = 0.0;
        double fractionalPart = 0.0;

        // Обработка целой части
        for (int i = 0; i < parts[0].length(); i++) {
            integerPart = integerPart * base + getNumericValue(parts[0].charAt(i));
        }

        // Обработка дробной части, если она есть
        if (parts.length > 1) {
            double baseFactor = 1.0 / base;
            for (int i = 0; i < parts[1].length(); i++) {
                fractionalPart += getNumericValue(parts[1].charAt(i)) * baseFactor;
                baseFactor /= base;
            }
        }

        double result = integerPart + fractionalPart;
        return isNegative ? -result : result;
    }

    private int getNumericValue(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else if (digit >= 'A' && digit <= 'F') {
            return 10 + (digit - 'A');
        } else {
            throw new IllegalArgumentException("Invalid character in number string");
        }
    }


    // Getters
    public double getNumber() {
        return number;
    }

    public String getNumberString() {
        return numberString;
    }

    public int getBase() {
        return base;
    }

    public int getPrecision() {
        return precision;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setBase(String base) {
        try{
            this.base = Integer.parseInt(base);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

    }

    public void setPrecision(int precision) {
        if (precision < 0) throw new IllegalArgumentException();
        this.precision = precision;
    }

    public void setNumberString(String numberString) {
        this.numberString = numberString;
    }
}

