package com.ciscodeto.main;

public class ArrayFiller {
    private int[] array;
    private int size;
    private boolean errorState = false;
    private String errorMessage = "Erro";

    public ArrayFiller() {
    }
    public void initializeArray(String s) {
        array = new int[]{30, 2, 39, 45, 89, 0, 0, 0, 0, 0};

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
