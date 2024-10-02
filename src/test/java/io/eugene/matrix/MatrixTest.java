package io.eugene.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testConstructorValidMatrix() {
        int[][] data = {
                { 1, 2 },
                { 3, 4 }
        };
        IMatrix matrix = new Matrix(data);

        assertEquals(2, matrix.getRowCount());
        assertEquals(2, matrix.getColumnCount());
        assertEquals(1, matrix.getElement(0, 0));
        assertEquals(4, matrix.getElement(1, 1));
    }

    @Test
    public void testConstructorEmptyMatrix() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Matrix(new int[][] {}));
        assertEquals("The number of rows and columns must be greater than 0", exception.getMessage());
    }

    @Test
    public void testGetElementOutOfBounds() {
        IMatrix matrix = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> matrix.getElement(2, 2));
        assertEquals("Indexes are out of range", exception.getMessage());
    }

    @Test
    public void testTransposeSquareMatrix() {
        IMatrix matrix = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        IMatrix transposed = matrix.transpose();

        assertEquals(new Matrix(new int[][] { { 1, 3 }, { 2, 4 } }), transposed);
    }

    @Test
    public void testTransposeNonSquareMatrix() {
        IMatrix matrix = new Matrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });
        Exception exception = assertThrows(UnsupportedOperationException.class, matrix::transpose);
        assertEquals("Matrix must have the same number of rows and columns", exception.getMessage());
    }

    @Test
    public void testMinValue() {
        IMatrix matrix = new Matrix(new int[][] { { 1, 2 }, { -3, 4 } });
        assertEquals(-3, matrix.min());
    }

    @Test
    public void testToString() {
        IMatrix matrix = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        assertEquals("{{1,2},{3,4}}", matrix.toString());
    }

    @Test
    public void testToStringWithOneRowAndColumn() {
        IMatrix matrix = new Matrix(new int[][] {
                { 1 }
        });
        assertEquals("{{1}}", matrix.toString());
    }

    @Test
    public void testToStringWithOneRowAndTwoColumn() {
        IMatrix matrix = new Matrix(new int[][] {
                { 1, 2 }
        });
        assertEquals("{{1,2}}", matrix.toString());
    }

    @Test
    public void testToStringWithTwoRowAndOneColumn() {
        IMatrix matrix = new Matrix(new int[][] {
                { 1 },
                { 2 }
        });
        assertEquals("{{1},{2}}", matrix.toString());
    }

    @Test
    public void testEqualsSameMatrix() {
        IMatrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        IMatrix matrix2 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        assertEquals(matrix1, matrix2);
    }

    @Test
    public void testNotEqualsDifferentMatrix() {
        IMatrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        IMatrix matrix2 = new Matrix(new int[][] { { 1, 2 }, { 5, 6 } });
        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void testAddSameSizeMatrices() {
        Matrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Matrix matrix2 = new Matrix(new int[][] { { 5, 6 }, { 7, 8 } });
        IMatrix result = matrix1.add( matrix2);

        assertEquals(new Matrix(new int[][] { { 6, 8 }, { 10, 12 } }), result);
    }

    @Test
    public void testAddDifferentSizeMatrices() {
        Matrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Matrix matrix2 = new Matrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> matrix1.add( matrix2));
        assertEquals("Matrices must be of the same sizes", exception.getMessage());
    }

    @Test
    public void testSubtractSameSizeMatrices() {
        Matrix matrix1 = new Matrix(new int[][] { { 5, 6 }, { 7, 8 } });
        Matrix matrix2 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        IMatrix result = matrix1.subtract(matrix2);

        assertEquals(new Matrix(new int[][] { { 4, 4 }, { 4, 4 } }), result);
    }

    @Test
    public void testSubtractDifferentSizeMatrices() {
        Matrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Matrix matrix2 = new Matrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> matrix1.subtract(matrix2));
        assertEquals("Matrices must be of the same sizes", exception.getMessage());
    }

    @Test
    public void testMultiplyConsistentMatrices() {
        Matrix matrix1 = new Matrix(new int[][] {
                { 1, 2 },
                { 3, 4 }
        });
        Matrix matrix2 = new Matrix(new int[][] {
                { 5, 6 },
                { 7, 8 }
        });
        Matrix result = matrix1.multiply(matrix2);

        assertEquals(new Matrix(new int[][] {
                { 19, 22 },
                { 43, 50 }
        }), result);
    }

    @Test
    public void testMultiplyInconsistentMatrices() {
        Matrix matrix1 = new Matrix(new int[][] {
                { 1, 2, 3, 4 }
        });
        Matrix matrix2 = new Matrix(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 }
        });
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> matrix1.multiply(matrix2));
        assertEquals("Matrices are not consistent for multiplication", exception.getMessage());
    }

    @Test
    public void testEqualsAndHashCode() {
        Matrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Matrix matrix2 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });

        assertEquals(matrix1, matrix2);
        assertEquals(matrix1.hashCode(), matrix2.hashCode());
    }

    @Test
    public void testNotEqualsAndHashCode() {
        Matrix matrix1 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
        Matrix matrix2 = new Matrix(new int[][] { { 5, 6 }, { 7, 8 } });

        assertNotEquals(matrix1, matrix2);
        assertNotEquals(matrix1.hashCode(), matrix2.hashCode());
    }
}
