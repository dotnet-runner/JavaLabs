import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Задание 1\n" +
                "Результат для строки \"пустая строка\": " + isStringFree("пустая строка") + "\n" +
                "Результат для строки \"                 \": " +  isStringFree("                 ")
        );
        System.out.println("Задание 2\n" +
                "Результат для строки \"пустая строка\": " + replaceAllVowel("пустая строка") + "\n" +
                "Результат для строки \"Apple Упало на голову Ньютона\": " +  replaceAllVowel("Apple Упало на голову Ньютона")
        );

        System.out.println("Задание 3");
        var employees = new Employee[] { new Employee("Охременко Дмитрий Сергеевич", 1347.11),
                                         new Employee("Зыбайло Михаил Дмитриевич", 5000.00),
                                         new Employee("Сватко Игорб Борисович", 90000),
                                         new Employee("Волкова Анастасия Глебова", 1700.05)
        };

        Report.generateReport(employees);

        System.out.print("Задание 4\n" +
                "Введите строку: ");
        var str = "";
        try(Scanner sc = new Scanner(System.in)) {
            str = sc.nextLine();
        }
        allRus(str);
    }

    public static boolean isStringFree(String value) {
        return value.isBlank();
    }

    public static String replaceAllVowel(String value) {
        return value.replaceAll("[аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY]", "");
    }

    public static void allRus(String value) {
        var words = value.split(" ");
        int counter = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].matches("[а-яёА-ЯЁ]+"))
                counter++;
        }
        var correctWords = new String[counter];
        counter = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].matches("[а-яёА-ЯЁ]+")){
                correctWords[counter] = words[i];
                counter++;
            }
        }
        for(int i = 0; i < correctWords.length; i++) {
            System.out.println(correctWords[i]);
        }
    }
}
