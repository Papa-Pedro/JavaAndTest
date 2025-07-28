package org.example.managerTwoStar;

public class CalculateManagerTwoStar {

    public static int amountOfViolation(int number){
        double result = 1;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                result += 1.0 / factorial(i);
            }
            else {
                result -= 1.0 / factorial(i);
            }
        }
        result *= factorial(number);
        return (int) Math.round(result);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

}
