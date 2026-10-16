public class Report {
    public static void generateReport(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("Полное имя: %-30s, зарплата: %10.2f\n", employees[i].getFullName(), employees[i].getSalary());
        }
    }
}
