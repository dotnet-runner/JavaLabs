package org.example;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class App {
    private static final int ARRAY_SIZE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private FileFormatter<String> stringFileFormatter = new FileFormatter<>(String.class);
    private FileFormatter<Integer> intFileFormatter = new FileFormatter<>(Integer.class);
    private FileFormatter<Double> doubleFileFormatter = new FileFormatter<>(Double.class);

    public static void main(String[] args) {
        try {
            var app = new App();
            app.task1();
            //app.task2();
            app.task3();
            //app.task4();
            app.task5();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void task1() throws IOException {
        var path = Path.of("D:\\Java\\files\\family.txt");

        System.out.println("Задание 1");

        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, stringFileFormatter.inFileView(Family.members));
            System.out.println("Успешная запись в файл");

            var content = Files.readAllLines(path);
            System.out.printf("Содержимое файла: %s\n", content.get(0));
        } catch (IOException ex) {
            throw new IOException("Возникла ошибка при работе с файлом!");
        }
    }

    public void task2() throws Exception {
        var path = Path.of("D:\\Java\\files\\f.txt");
        List<Integer> tenIntNumbers = new ArrayList<>(ARRAY_SIZE);

        System.out.println("Задание 2");
        try {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                System.out.printf("Введите %d число: ", i + 1);
                var number = scanner.nextInt();
                tenIntNumbers.add(number);
            }

            Files.deleteIfExists(path);
            Files.createFile(path);
            var fileWriteContent = intFileFormatter.inFileView(tenIntNumbers);
            Files.writeString(path, fileWriteContent);

            var fileReadContent = Files.readAllLines(path).get(0);
            var data = intFileFormatter.fromFileView(fileReadContent);
            var positiveNumbersCount = data.stream().filter(num -> num > 0).count();
            System.out.printf("Содержимое файла: %s; Положительных чисел: %d\n", fileReadContent, positiveNumbersCount);
        } catch (InputMismatchException ex) {
            throw new InputMismatchException("Было введено не число!");
        } catch (IOException ex) {
            throw new IOException("Возникла ошибка при работе с файлами проверьте доступность деректории!");
        } catch (Exception ex) {
            throw new Exception("Возникла ошибка при работе задания 2");
        }
    }

    public void task3() {
        var path = Path.of("D:\\Java\\files\\f_random.txt");
        List<Integer> collection = new ArrayList<>(ARRAY_SIZE);

        System.out.println("Задание 3");
        try {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                collection.add(random.nextInt(0, 201));
            }

            var fileWriteContent = intFileFormatter.inFileView(collection);
            System.out.printf("Содержание массива: %s\n", fileWriteContent);

            Files.writeString(path, fileWriteContent);

            var fileReadContent = Files.readAllLines(path).get(0);
            var data = intFileFormatter.fromFileView(fileReadContent);

            List<Integer> belowHundred = new ArrayList<>();
            List<Integer> moreHundred = new ArrayList<>();

            for (var dat : data) {
                if (dat > 100)
                    moreHundred.add(dat);
                else
                    belowHundred.add(dat);
            }

            var belowHundredFileWrite = intFileFormatter.inFileView(belowHundred);
            var moreHundredFileWrite = intFileFormatter.inFileView(moreHundred);

            System.out.printf("Контент g.txt: %s\n" +
                    "Контент h.txt: %s\n", belowHundredFileWrite, moreHundredFileWrite);

            var pathBelowHundred = Path.of("D:\\Java\\files\\g.txt");
            var pathMoreHundred = Path.of("D:\\Java\\files\\h.txt");

            Files.writeString(pathBelowHundred, belowHundredFileWrite);
            Files.writeString(pathMoreHundred, moreHundredFileWrite);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при работе с файлами", ex);
        }
    }

    public void task4() {
        Path path = Path.of("D:\\Java\\files\\concentration.txt");
        List<Double> concentrations = new ArrayList<>();

        System.out.println("Задание 4");
        try {
            System.out.println("Введите 15 вещественных значений концентрации:");
            for (int i = 1; i <= 15; i++) {
                System.out.printf("Значение %d: ", i);
                double val = scanner.nextDouble();
                concentrations.add(val);
            }
            String fileWriteContent = doubleFileFormatter.inFileView(concentrations);
            Files.writeString(path, fileWriteContent);

            String fileReadContent = Files.readAllLines(path).get(0);
            List<Double> data = doubleFileFormatter.fromFileView(fileReadContent);

            double average = data.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            System.out.printf("Средняя концентрация вещества: %.4f\n", average);
        }
        catch (InputMismatchException ex) {
            throw new InputMismatchException("Было введено не число!");
        }
        catch (IOException ex) {
            System.err.println("Произошла ошибка при работе с файлом: " + ex.getMessage());
        }
    }

    public void task5() {
        Path path = Path.of("D:\\Java\\files\\f5.txt");

        List<Integer> collection = new ArrayList<>(ARRAY_SIZE);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            collection.add(random.nextInt(1, 100));
        }

        try {
            String fileWriteContent = intFileFormatter.inFileView(collection);
            System.out.printf("Сгенерированные числа: %s\n", fileWriteContent);
            Files.writeString(path, fileWriteContent);

            var fileReadContent = Files.readAllLines(path).get(0);
            List<Integer> data = intFileFormatter.fromFileView(fileReadContent);

            var matchCount = data.stream()
                    .filter(num -> num % 2 == 0 && num % 3 == 0)
                    .count();

            System.out.printf("Количество чисел, кратных 2 и 3 одновременно: %d\n", matchCount);
        }
        catch (IOException ex) {
            throw new RuntimeException("Ошибка при работе с файлом", ex);
        }
    }
}
