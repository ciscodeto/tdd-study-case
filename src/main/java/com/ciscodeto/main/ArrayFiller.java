package com.ciscodeto.main;

import java.util.HashSet;
import java.util.Set;

public class ArrayFiller {
    private int[] array = new int[10];
    private int size = 0;
    private boolean errorState = false;
    private String errorMessage = "Erro";

    public ArrayFiller() {
    }
    public void initializeArray(String s) {
        String[] values = s.trim().split("\\s+");
        if (values.length != 5) {
            errorState = true;
            return;
        }

        Set<Integer> numbers = new HashSet<>();

        for (String value : values) {
            int num;

            try {
                num = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                errorState = true;
                return;
            }
            if (!numbers.add(num)) {
                errorState = true;
                return;
            }
            array[size++] = num;
        }
    }

    public boolean hasError() {
        return errorState;
    }

    public int[] getCurrentArray() {
        return array;
    }

    public void processNumber(int i) {
    }

    public boolean isFinished() {
        return true;
    }
}
