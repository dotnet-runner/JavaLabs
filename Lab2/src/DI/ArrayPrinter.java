package DI;

import java.util.stream.DoubleStream;

public class ArrayPrinter implements IArrayPrinter {
    public void PrintArray(double[] arr) {
        System.out.print("Массив: ");
        var stream = DoubleStream.of(arr);
        stream.forEach(x-> System.out.print(x + " "));
        System.out.println();
    }

    public void PrintArray(double[][] arr) {
        System.out.println("Массив: ");
        for(int i = 0; i < arr.length; i++){
            var stream = DoubleStream.of(arr[i]);
            stream.forEach(x-> System.out.print(x + " "));
            System.out.println();
        }
    }
}
