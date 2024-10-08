package com.ciscodeto.main;

import java.util.HashSet;
import java.util.Set;

public class ArrayFiller {
    private int[] array = new int[10];
    private int size = 0;
    private boolean errorState = false;


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

    public void processNumber(int num) {
        if (errorState) {
            return;
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
                return;
            }
            array[size++] = num;
        }
    }

    public boolean isFinished() {
        return size == 0 || size == array.length;
    }

    public void processInput(String input) {
        if (errorState) {
            return;
        }
        try {
            int num = Integer.parseInt(input.trim());
            processNumber(num);
        } catch (NumberFormatException e) {
            errorState = true;
        }
    }

    public int getSize() {
        return size;
    }

    public String getErrorMessage() {
        String errorMessage = "Erro";
        return errorMessage;
    }
}
