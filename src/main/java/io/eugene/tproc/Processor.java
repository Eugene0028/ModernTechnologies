package io.eugene.tproc;

public abstract class Processor<T extends Number> {
    protected T lopRes;  // Левый операнд
    protected T rop;     // Правый операнд
    protected TOprtn operation;  // Операция

    // Конструктор
    public Processor(T defaultValue) {
        this.lopRes = defaultValue;
        this.rop = defaultValue;
        this.operation = TOprtn.NONE;
    }

    // Сброс процессора
    public void resetProcessor(T defaultValue) {
        this.lopRes = defaultValue;
        this.rop = defaultValue;
        this.operation = TOprtn.NONE;
    }

    // Сброс операции
    public void clearOperation() {
        this.operation = TOprtn.NONE; // Операция не установлена
    }

    // Чтение левый операнд
    public T readLopRes() {
        return lopRes;
    }

    // Запись левого операнда
    public void setLopRes(T operand) {
        this.lopRes = operand;
    }

    // Чтение правый операнд
    public T readRop() {
        return rop;
    }

    // Запись правого операнда
    public void setRop(T operand) {
        this.rop = operand;
    }

    // Чтение состояния
    public TOprtn readOperation() {
        return operation;
    }

    // Запись состояния
    public void setOperation(TOprtn operation) {
        this.operation = operation;
    }

    // Метод для выполнения арифметической операции
    protected T performOperation(T a, T b, TOprtn op) throws ArithmeticException {
        return switch (op) {
            case ADD -> add(a, b);
            case SUB -> subtract(a, b);
            case MUL -> multiply(a, b);
            case DVD -> divide(a, b);
            default -> throw new UnsupportedOperationException("Операция не поддерживается");
        };
    }

    // Абстрактные методы для арифметических операций
    protected abstract T add(T a, T b);
    protected abstract T subtract(T a, T b);
    protected abstract T multiply(T a, T b);
    protected abstract T divide(T a, T b) throws ArithmeticException;
    protected abstract T negative(T a);

    public void runOperation() throws ArithmeticException{
        if (operation != TOprtn.NONE) {
            lopRes = performOperation(lopRes, rop, operation);
        }
    }
    public void runFunction(TFunc func) {
        switch (func) {
            case REV:
                rop = negative(rop);
                break;
            case SQR:
                rop = multiply(rop, rop);
                break;
            default:
                break;
        }
    }
}
