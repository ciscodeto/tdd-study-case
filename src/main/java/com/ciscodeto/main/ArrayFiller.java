package com.ciscodeto.main;

import java.util.HashSet;
import java.util.Set;

public class ArrayFiller {
    private int[] array = new int[10];
    private int size = 0;
    private boolean errorState = false;
    private String errorMessage = "Erro";

    public ArrayFiller() {}

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
        return array.clone();
    }

    public boolean processNumber(int num) {
        if (errorState) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = 0;
        } else {
            if (size >= 10) {
                return false;
            }
            array[size++] = num;
        }
        return true;
    }

    public boolean isFinished() {
        return true;
    }
}
