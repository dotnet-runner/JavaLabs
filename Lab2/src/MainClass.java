import DI.ArrayFiller;
import DI.ArrayPrinter;
import DI.IArrayFiller;
import DI.IArrayPrinter;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class MainClass {

    public static void main(String[] args) {
        IArrayFiller filler = new ArrayFiller();
        IArrayPrinter printer = new ArrayPrinter();

        var singleArr = new double[15];
        filler.generateArray(singleArr);
        var task1Res = findMinElementIndex(singleArr);
        printer.PrintArray(singleArr);
        System.out.println("Индекс минимального элемента в массиве: " + task1Res);

        var manyArray = filler.getBaseManyArray();
        printer.PrintArray(manyArray);
        var task2Res = findMaxElementInColumn(manyArray);
        printer.PrintArray(task2Res);
    }

    private static int findMinElementIndex(double[] arr) {
        DoubleStream arrStream = Arrays.stream(arr);
        var minEl = arrStream.min().orElseThrow();
        var minElIndex = 0;

        for(var i = 0; i < arr.length; i++) {
            if(arr[i] == minEl) {
                minElIndex = i;
                break;
            }
        }

        return ++minElIndex;
    }

    private static double[] findMaxElementInColumn(double[][] arr) {
        var totalColumns = arr[0].length;
        double[] maxInColumns = new double[totalColumns];

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < totalColumns; col++) {
                if (arr[row][col] > maxInColumns[col]) {
                    maxInColumns[col] = arr[row][col];
                }
            }
        }

        return maxInColumns;
    }
}
