package DI;

import java.util.Random;
import java.util.Scanner;

public class ArrayFiller implements IArrayFiller {
    private static final Random RANDOMIZER = new Random();

    public void generateArray(double[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = RANDOMIZER.nextDouble(-2000.0, 2000.0);
        }
    }

    public void generateArray(double[][] arr) {
        for(int i = 0; i < arr.length; i++){
            generateArray(arr[i]);
        }
    }

    public double[] getBaseSingleArray() {
        return new double[] {8.32, 13.44, 1.15, 14.12, 19.84, 18.02, 3.99 };
    }

    public double[][] getBaseManyArray() {
        return new double[][] {
                {1, 2, 21},
                {5, 10, 4},
                {7, 1, 0}
        };
    }

    public double[] userArrayInput(Scanner scanner, int arrayLen) {
        var arr = new double[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.print("Введите " + (i + 1) + " элемент: ");
            arr[i] = scanner.nextDouble();
        }
        return arr;
    }

    public double[][] userArrayInput(Scanner scanner, int arrayRows, int arrayColumn) {
        var arr = new double[arrayRows][arrayColumn];
        for(int i = 0; i < arrayRows; i++){
            arr[i] = userArrayInput(scanner, arrayColumn);
        }
        return arr;
    }
}
