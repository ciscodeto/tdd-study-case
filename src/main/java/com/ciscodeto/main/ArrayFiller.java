package com.ciscodeto.main;

public class ArrayFiller {
    private int[] array;
    private int size;

    public ArrayFiller() {
    }
    public void initializeArray(String s) {
        array = new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
    }

    public int[] getCurrentArray() {
        return array;
    }

}
