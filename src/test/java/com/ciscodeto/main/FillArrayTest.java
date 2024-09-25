package com.ciscodeto.main;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.fail;

public class FillArrayTest {

    @Test
    @DisplayName("Should Insert 5 initial numbers")
    void shouldInsert5InitialNumbers() {
        ArrayFiller arrayFiller = new ArrayFiller();
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
        ArrayFiller arrayFiller = new ArrayFiller();

        assertThat(arrayFiller);
        fail();
    }


}
