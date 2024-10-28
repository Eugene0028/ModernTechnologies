package io.eugene.tmem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryTest {
    private MemoryDoubleImpl doubleMemory;
    private MemoryIntImpl intMemory;

    @BeforeEach
    void setUp() {
        doubleMemory = new MemoryDoubleImpl(5.0);
        intMemory = new MemoryIntImpl(10);
    }

    @Test
    void testAddDoubleNumbers() {
        doubleMemory.add(2.0); // 5.0 + 2.0
        assertEquals(7.0, doubleMemory.getFNumber());
    }

    @Test
    void testAddIntNumbers() {
        intMemory.add(5); // 10 + 5
        assertEquals(15, intMemory.getFNumber());
    }

    @Test
    void testWriteAndReadDouble() {
        doubleMemory.write(20.0);
        assertEquals(20.0, doubleMemory.getFNumber());
    }

    @Test
    void testWriteAndReadInt() {
        intMemory.write(25);
        assertEquals(25, intMemory.getFNumber());
    }

    @Test
    void testCleanDoubleMemory() {
        doubleMemory.clean();
        assertEquals("OFF", doubleMemory.readMemoryState());
        assertEquals(0.0, doubleMemory.getFNumber());
    }

    @Test
    void testCleanIntMemory() {
        intMemory.clean();
        assertEquals("OFF", intMemory.readMemoryState());
        assertEquals(0, intMemory.getFNumber());
    }

    @Test
    void testMemoryState() {
        assertEquals("OFF", doubleMemory.readMemoryState());
        doubleMemory.add(5.0); // Change state to ON
        assertEquals("ON", doubleMemory.readMemoryState());
    }
}
