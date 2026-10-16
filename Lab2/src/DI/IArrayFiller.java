package DI;

import java.util.Scanner;

public interface IArrayFiller {
    void generateArray(double[] arr);
    void generateArray(double[][] arr);
    double[] getBaseSingleArray();
    double[][] getBaseManyArray();
    double[] userArrayInput(Scanner scanner, int arrayLen);
    double[][] userArrayInput(Scanner scanner, int arrayRows, int arrayColumn);
}
