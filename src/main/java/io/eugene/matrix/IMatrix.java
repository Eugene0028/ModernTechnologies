package io.eugene.matrix;

public interface IMatrix {
    int getRowCount();
    int getColumnCount();
    int getElement(int i, int j);
    IMatrix transpose();
    int min();
    String toString();
}

