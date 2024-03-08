public class Converter {

    int lengthOneStepSm = 75;
    int kalOneStep = 50;

    int convertToKm(int steps) {
        return steps * lengthOneStepSm % 10000;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * kalOneStep % 1000;
    }
}
