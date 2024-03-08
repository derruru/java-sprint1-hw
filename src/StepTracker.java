import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {

        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        if (month > 12 || month <= 0) {
            System.out.println("Введен неверный месяц");
            return;
        }

        System.out.println("Введите номер дня");
        int day = scanner.nextInt();

        if (day <= 0 || day > 30) {
            System.out.println("Введено неверное количество дней");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Введено неверное количество шагов");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;

        System.out.println("Значение сохранено");
    }

    void changeStepGoal() {

        System.out.println("Введите новую цель");
        goalByStepsPerDay = scanner.nextInt();

        if (goalByStepsPerDay <= 0) {
            System.out.println("Некорректное значение");
            return;
        }

        System.out.println("Значение сохранено");
    }

    void printStatistic() {

        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        if (month <= 0 || month > 12) {
            System.out.println("Введен неверный месяц");
        }

        MonthData monthData = monthToData[month - 1];

        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за введённый месяц - " + monthData.sumStepsFromMonth());
        System.out.println("Максимальное количество шагов - " + monthData.maxSteps());
        System.out.println("Среднее количество шагов - " + monthData.sumStepsFromMonth() / 30);
        System.out.println("Пройденная дистанция в км - " + converter.convertToKm(monthData.sumStepsFromMonth()));
        System.out.println("Сожжённые килокалории - " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("Лучшая серия - " + monthData.bestSeries(goalByStepsPerDay));
    }
}
