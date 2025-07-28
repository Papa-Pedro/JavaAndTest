package org.example.managerTwoStar;

public class CalculateManagerTwoStar {

    public static int amountOfViolation(int number){
        int result = 0;
        for (int i = 0; i <= number; i++) {
            result += i;
        }
        return result - number;
    }

}
