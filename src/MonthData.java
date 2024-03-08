public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {
            System.out.println("День " + (i + 1) + " - " + days[i]);
        }
    }

    int sumStepsFromMonth() {

        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += days[i];
        }
        return sum;
    }

    int maxSteps() {

        int max = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > max) {
                max = days[i];
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {

        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries += 1;
            } else if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}