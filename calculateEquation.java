/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Short50;
// replace your package name here

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Number {
    public Float checkin(String floatString) {
        try {
            return Float.parseFloat(floatString);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public boolean isPerfectSquare(float number) {
        if (number < 0) return false;
        float sqrt = (float) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}

public class calculateEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Number numChecker = new Number();
        boolean exit = false;

        while (!exit) {
            System.out.println("========= Equation Program =========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");
            String choiceStr = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    float a = getFloat(sc, numChecker, "Enter A: ");
                    float b = getFloat(sc, numChecker, "Enter B: ");
                    List<Float> sol = new calculateEquation().calculateEquation(a, b);
                    displaySolution(sol);
                    displayNumbers(new float[]{a, b}, numChecker);
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    float aa = getFloat(sc, numChecker, "Enter A: ");
                    float bb = getFloat(sc, numChecker, "Enter B: ");
                    float cc = getFloat(sc, numChecker, "Enter C: ");
                    List<Float> solq = new calculateEquation().calculateQuadraticEquation(aa, bb, cc);
                    displaySolution(solq);
                    displayNumbers(new float[]{aa, bb, cc}, numChecker);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    // Invalid choice, loop again
                    break;
            }
        }
        sc.close();
    }

    private static float getFloat(Scanner sc, Number checker, String prompt) {
        Float val = null;
        while (val == null) {
            System.out.print(prompt);
            String in = sc.nextLine();
            val = checker.checkin(in);
            if (val == null) {
                System.out.println("Please input number");
            }
        }
        return val;
    }

    private static void displaySolution(List<Float> sol) {
        if (sol == null) {
            System.out.println("No solution");
        } else if (sol.isEmpty()) {
            System.out.println("Infinitely many solutions");
        } else {
            if (sol.size() == 1) {
                System.out.printf("Solution: x = %.3f%n", sol.get(0));
            } else {
                System.out.printf("Solution: x1 = %.3f and x2 = %.3f%n", sol.get(0), sol.get(1));
            }
        }
    }

    private static void displayNumbers(float[] coeffs, Number checker) {
        List<String> odds = new ArrayList<>();
        List<String> evens = new ArrayList<>();
        List<String> squares = new ArrayList<>();
        for (float n : coeffs) {
            String s = Float.toString(n);
            if (checker.isOdd(n)) {
                odds.add(s);
            } else if (n % 2 == 0) {
                evens.add(s);
            }
            if (checker.isPerfectSquare(n)) {
                squares.add(s);
            }
        }
        if (!odds.isEmpty()) {
            System.out.println("Number is Odd: " + String.join(", ", odds));
        }
        if (!evens.isEmpty()) {
            System.out.println("Number is Even: " + String.join(", ", evens));
        }
        if (!squares.isEmpty()) {
            System.out.println("Number is Perfect Square: " + String.join(", ", squares));
        }
    }

    public List<Float> calculateEquation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                return new ArrayList<>();
            } else {
                return null;
            }
        } else {
            List<Float> res = new ArrayList<>();
            res.add(-b / a);
            return res;
        }
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> res = new ArrayList<>();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return res; // empty
                } else {
                    return null;
                }
            } else {
                res.add(-c / b);
                return res;
            }
        } else {
            float d = b * b - 4 * a * c;
            if (d < 0) {
                return null;
            } else if (d == 0) {
                float x = -b / (2 * a);
                res.add(x);
                res.add(x);
                return res;
            } else {
                float sqrtD = (float) Math.sqrt(d);
                float x1 = (-b + sqrtD) / (2 * a);
                float x2 = (-b - sqrtD) / (2 * a);
                res.add(x1);
                res.add(x2);
                return res;
            }
        }
    }
}
