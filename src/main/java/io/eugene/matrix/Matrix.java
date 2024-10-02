package io.eugene.matrix;

import io.eugene.exceptions.MyException;

public class Matrix implements IMatrix {
    private final int[][] matrix;
    private final int rows;
    private final int cols;

    public Matrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            throw new MyException("The number of rows and columns must be greater than 0");
        }
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, matrix[0].length);
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return cols;
    }

    @Override
    public int getElement(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Indexes are out of range");
        }
        return matrix[i][j];
    }

    @Override
    public IMatrix transpose() {
        if (rows != cols) {
            throw new UnsupportedOperationException("Matrix must have the same number of rows and columns");
        }
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return new Matrix(transposed);
    }

    @Override
    public int min() {
        int minValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                minValue = Math.min(minValue, value);
            }
        }
        return minValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < rows; i++) {
            sb.append("{");
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]);
                if (j < cols - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i < rows - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Matrix matrix1 = (Matrix) obj;
        if (rows != matrix1.rows || cols != matrix1.cols) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != matrix1.matrix[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(matrix);
    }

    public Matrix add(Matrix b) {
        Matrix a = this;
        if (a.rows != b.rows || a.cols != b.cols) {
            throw new UnsupportedOperationException("Matrices must be of the same sizes");
        }
        int[][] result = new int[a.rows][a.cols];
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                result[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix b) {
        Matrix a = this;
        if (a.rows != b.rows || a.cols != b.cols) {
            throw new UnsupportedOperationException("Matrices must be of the same sizes");
        }
        int[][] result = new int[a.rows][a.cols];
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                result[i][j] = a.matrix[i][j] - b.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix b) {
        Matrix a = this;
        if (a.cols != b.rows) {
            throw new UnsupportedOperationException("Matrices are not consistent for multiplication");
        }
        int[][] result = new int[a.rows][b.cols];
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                for (int k = 0; k < a.cols; k++) {
                    result[i][j] += a.matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public static boolean notEquals(Matrix a, Matrix b) {
        return !a.equals(b);
    }
}

