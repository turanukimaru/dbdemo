package com.example.diffbluedemo.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalcDiffblueTest {
    /**
     * Method under test: {@link Calc#add(Integer, Integer)}
     */
    @Test
    void testAdd() {
        assertEquals(4, (new Calc()).add(2, 2).intValue());
        assertEquals(6, (new Calc()).add(3, 3).intValue());
        assertEquals(5, (new Calc()).add(3, 2).intValue());
        assertEquals(3, (new Calc()).add(1, 2).intValue());
    }

    /**
     * Method under test: {@link Calc#sub(Integer, Integer)}
     */
    @Test
    void testSub() {
        assertEquals(0, (new Calc()).sub(3, 3).intValue());
        assertEquals(-2, (new Calc()).sub(1, 3).intValue());
        assertEquals(-3, (new Calc()).sub(0, 3).intValue());
        assertEquals(-4, (new Calc()).sub(-1, 3).intValue());
    }
}
