package com.ciscodeto.main;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.fail;

public class FillArrayTest {

    private ArrayFiller arrayFiller;

    @BeforeEach
    void setUp() {
        arrayFiller = new ArrayFiller();
    }

    @Test
    @DisplayName("Should Insert 5 initial numbers")
    void shouldInsert5InitialNumbers() {
        arrayFiller.initializeArray("1 2 3 4 5");

        int[] expected = new int[10];
        for (int i = 0; i < 5; i++) {
            expected[i] = i + 1;
        }

        assertThat(arrayFiller.getCurrentArray()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should Handle Duplicate Initial Numbers")
    void shouldHandleDuplicateInitialNumbers() {
        arrayFiller.initializeArray("1 2 2 3 4");

        assertThat(arrayFiller.hasError()).isTrue();
    }

    @Test
    @DisplayName("Should Handle Less Than Five Initial Numbers")
    void shouldHandleLessThanFiveInitialNumbers() {
        arrayFiller.initializeArray("1 2 3 4");

        assertThat(arrayFiller.hasError()).isTrue();
    }

    @Test
    @DisplayName("Should Handle More Than Five Initial Numbers")
    void shouldHandleMoreThanFiveInitialNumbers() {
        arrayFiller.initializeArray("1 2 3 4 5 6");

        assertThat(arrayFiller.hasError()).isTrue();
    }

    @Test
    @DisplayName("Should Insert A Number")
    void shouldInsertANumber() {
        arrayFiller.initializeArray("1 2 3 4 5");
        int[] expected = new int[10];

        for (int i = 0; i < 6; i++) {
            expected[i] = i + 1;
        }

        arrayFiller.processNumber(6);
        assertThat(arrayFiller.getCurrentArray()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should Remove A Number")
    void shouldRemoveANumber() {
        arrayFiller.initializeArray("1 2 3 4 5");
        int[] expected = new int[10];

        for (int i = 0; i < 4; i++) {
            expected[i] = i + 1;
        }

        arrayFiller.processNumber(4);
        assertThat(arrayFiller.getCurrentArray()).isEqualTo(expected);
    }


    @Test
    @DisplayName("Should Stop At The Tenth Number")
    void shouldStopAtTheTenthNumber() {
        arrayFiller.initializeArray("1 2 3 4 5");
        arrayFiller.processNumber(6);
        arrayFiller.processNumber(7);
        arrayFiller.processNumber(8);
        arrayFiller.processNumber(9);
        arrayFiller.processNumber(10);

        assertThat(arrayFiller.isFinished()).isTrue();
    }

    @Test
    @DisplayName("Should Stop When Empty")
    void shouldStopWhenEmpty() {
        arrayFiller.initializeArray("1 2 3 4 5");
        arrayFiller.processNumber(1);
        arrayFiller.processNumber(2);
        arrayFiller.processNumber(3);
        arrayFiller.processNumber(4);
        arrayFiller.processNumber(5);

        assertThat(arrayFiller.isFinished()).isTrue();
    }


}
