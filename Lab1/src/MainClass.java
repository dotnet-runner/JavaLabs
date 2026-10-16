import java.util.Scanner;

public class MainClass {

    private static final Scanner _scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

    public static void main(String[] arg) {
        while(true)
            labCore();
    }

    private static void labCore() {
        System.out.print("Какое упражнение стоит запустить?\n" +
                "От 1 до 3, 0 - для выхода из программы\n" +
                "Номер задания: ");
        var taskNumber = _scanner.nextShort();

        if(taskNumber > 3 || taskNumber < 0) {
            System.out.println("Некорректный ввод!");
            return;
        }

        var diff = "-".repeat(15);
        System.out.println(diff + "Task " + taskNumber + diff);
        switch(taskNumber) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            default:
                _scanner.close();
                System.exit(0);
        }

        System.out.println(diff + "-".repeat(6) + diff);
    }

    private static void task1() {
        System.out.print("Введите количество дюймов: ");
        var inches = _scanner.nextDouble();
        var convertRes = convertInchToCentimeters(inches);
        System.out.format("Введенное количество дюймов: %.2f - это %.2f сантиметров\n", inches, convertRes);
    }

    private static double convertInchToCentimeters(double inches) {
        return inches * 2.54;
    }

    private static void task2() {
        System.out.print("Введите первое число: ");
        var number1 = _scanner.nextDouble();
        System.out.print("Введите второе число: ");
        var number2 = _scanner.nextDouble();
        System.out.print("Введите третье число: ");
        var number3 = _scanner.nextDouble();

        var res = "";
        if(number1 == number2 && number2 == number3)
            res = "одинаковые числа ( " + number1  +" )";
        else if(number1 == number2 && number1 > number3)
            res = "первое и второе число ( " + number1  +" ) являются самими большими";
        else if(number1 == number3 && number1 > number2)
            res = "первое и третье число ( " + number1  +" ) являются самыми большими";
        else if(number2 == number3 && number2 > number1)
            res = "второе и третье число ( " + number2  +" ) являются самими большими";
        else if(number1 > number2 && number1 > number3)
            res = "первое число ( " + number1  +" ) является самым большим";
        else if(number2 > number1 && number2 > number3)
            res = "второе число ( " + number2  +" ) является самым большим";
        else
            res = "третье число ( " + number3  +" ) является самым большим";

        System.out.println(res);
    }

    private static void task3() {
        System.out.print("Введите число, таблицу умножения которого хотите увидеть: ");
        var number = _scanner.nextShort();
        var counter = 1;
        var multipliedNumbers = new int[10];
        do {
            multipliedNumbers[counter - 1] = number * counter;
        } while(counter++ != 10);

        drowMultiplyTable(multipliedNumbers);
    }

    private static void drowMultiplyTable(int[] multipliedNumbers) {
        var border = "-".repeat(29);
        var titleFreeSpace = " ".repeat(2);
        var freeSpace = " ".repeat(5);

        System.out.println(border);
        System.out.println('|' + titleFreeSpace + "Множитель" + titleFreeSpace + '|' + titleFreeSpace + "Результат" + titleFreeSpace + '|');
        System.out.println(border);
        for(var i = 1; i <= 10; i++) {
            var diff = titleFreeSpace.length() * 2 + 9 - freeSpace.length();
            var firstColumn = diff - (i + "").length();
            var secondColumn = diff - (multipliedNumbers[i-1] + "").length();
            System.out.println('|' + freeSpace + i + " ".repeat(firstColumn > 0 ? firstColumn : 0) + '|'
                    + freeSpace + multipliedNumbers[i-1] + " ".repeat(secondColumn > 0 ? secondColumn : 0) + '|');
            System.out.println(border);
        }
    }
}
