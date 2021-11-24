package com.thomasgassmann.exercises;

public class BowShot {
    public static double K = 97442343.345d;
    public static int count = 0;

    //Prints the distance from the correct result
    public static void checkAnswer(double result) {
        System.out.println("Found an answer that was " + Math.abs(result - K) + " meters away. You used " + count + " shots");
    }

    //shoots an arrow and returns if the arrow hits the wall or not
    public static boolean shoot(double dist) {
        count++;
        return dist < K;
    }

    public static void evaluate() {
        double upper = 1;
        while (shoot(upper)) {
            upper = 2 * upper;
        }
        double lower = upper / 2;

        while ( upper - lower > (2d/100)) {
            double mid = (upper + lower) / 2;
            if (shoot(mid)) {
                lower = mid;
            } else {
                upper = mid;
            }
        }

        checkAnswer((lower + upper) / 2);
    }
}
