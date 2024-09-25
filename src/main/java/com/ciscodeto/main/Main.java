package com.ciscodeto.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayFiller arrayFiller = new ArrayFiller();

        System.out.println("Please enter 5 unique numbers separated by spaces:");
        String initialInput = scanner.nextLine();

        arrayFiller.initializeArray(initialInput);

        if (arrayFiller.hasError()) {
            System.out.println(arrayFiller.getErrorMessage());
            return;
        }

        while (true) {
            System.out.println("Current array:");
            printArray(arrayFiller.getCurrentArray(), arrayFiller.getSize());

            System.out.println("Enter a number:");
            String input = scanner.nextLine();

            arrayFiller.processInput(input);
            if (arrayFiller.hasError()) {
                System.out.println(arrayFiller.getErrorMessage());
                break;
            }

            if (arrayFiller.isFinished()) {
                System.out.println("Array filling is finished.");
                break;
            }
        }
    }

    private static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}