package utils;

public class Calculation {

    private static double amount;
    private static double period;
    private static double replenishMonthly;
    private static double earned;
    private static double replenishTotal;
    private static double result;
    private static double replenishTotalExpected = replenishMonthly * period;
    private static double resultExpected = amount + replenishTotalExpected + earned;


    public static void setAmount(String value) {
        amount = toDouble(value);
    }
    public static void setPeriod(String value) {
        period = toDouble(value);
    }
    public static void setReplenishMonthly(String value) {
        replenishMonthly = toDouble(value);
    }
    public static void setEarned(String value) {
        earned = toDouble(value);
    }
    public static void setReplenishTotalExpected(String value) {
        replenishTotalExpected = toDouble(value);
    }
    public static void setResultExpected(String value) {
        resultExpected = toDouble(value);
    }

    public static boolean checkReplenishTotal() {
        return check(replenishTotalExpected, replenishTotal);
    }

    public static boolean checkResult() {
        return check(resultExpected, result);
    }

    private static boolean check(double value1, double value2) {
        return Math.abs(value1 - value2) < 1;
    }

    private static double toDouble(String value) {
        return Double.parseDouble(value.replaceAll("[^\\d,]]", "").replaceAll(",", "\\."));
    }
}
