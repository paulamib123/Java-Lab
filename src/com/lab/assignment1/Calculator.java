package com.lab.assignment1;
import java.lang.Math;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        CalculatorHelper calc = new CalculatorHelper();
        Scanner sc = new Scanner(System.in);
        double num1, num2, result;
        double sum = 0;
        int n = 0;
        char ch;
        String ans = "";
        do {
            System.out.println("MENU");
            System.out.println("1. ADDITION");
            System.out.println("2. SUBTRACTION");
            System.out.println("3. MULTIPLICATION");
            System.out.println("4. DIVISION");
            System.out.println("5. SQUARE ROOT");
            System.out.println("6. POWER");
            System.out.println("7. MEAN");
            System.out.println("8. VARIANCE");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter number 1: ");
                    num1= sc.nextDouble();
                    System.out.print("Enter number 2: ");
                    num2 = sc.nextDouble();
                    result = calc.add(num1, num2);
                    System.out.println("Addition of " + num1 + " + " + num2 + " is " + result);
                    break;

                case 2:
                    System.out.print("Enter number 1: ");
                    num1= sc.nextDouble();
                    System.out.print("Enter number 2: ");
                    num2 = sc.nextDouble();
                    result = calc.subtract(num1, num2);
                    System.out.println("Subtraction of " + num1 + " - " + num2 + " is " + result);
                    break;

                case 3:
                    System.out.print("Enter number 1: ");
                    num1= sc.nextDouble();
                    System.out.print("Enter number 2: ");
                    num2 = sc.nextDouble();
                    result = calc.multiply(num1, num2);
                    System.out.println("Product of " + num1 + " * " + num2 + " is " + result);
                    break;

                case 4:
                    System.out.print("Enter number 1: ");
                    num1= sc.nextDouble();
                    System.out.print("Enter number 2: ");
                    num2 = sc.nextDouble();
                    result = calc.divide(num1, num2);
                    System.out.println("Division of " + num1 + " / " + num2 + " is " + result);
                    break;

                case 5:
                    System.out.print("Enter number: ");
                    num1 = sc.nextDouble();
                    result = calc.sqrt(num1);
                    System.out.println("Square root of " + num1 + " is " + result);
                    break;

                case 6:
                    System.out.print("Enter base: ");
                    num1= sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    num2 = sc.nextDouble();
                    result = calc.power(num1, num2);
                    System.out.println("Power is " + result);
                    break;

                case 7:
                    while (!ans.equals("end")) {
                        System.out.print("Enter number : ");
                        num1 = sc.nextDouble();
                        sum += num1;
                        n++;
                        System.out.println("Do you want to enter more numbers?");
                        System.out.println("Enter end to stop");
                        System.out.println("Enter yes to continue");
                        ans = sc.next();
                    }
                    result = calc.mean(sum, n);
                    System.out.println("Mean is " + result);
                    break;

                case 8:
                    ans = "";
                    sum = 0;
                    n = 0;
                    while (!ans.equals("end")) {
                        System.out.print("Enter number : ");
                        num1 = sc.nextDouble();
                        sum += num1;
                        n++;
                        System.out.println("Do you want to enter more numbers?");
                        System.out.println("Enter end to stop");
                        System.out.println("Enter yes to continue");
                        ans = sc.next();
                    }
                    result = calc.variance(sum, n);
                    System.out.println("Variance is " + result);
                    break;

                default:
                    System.out.println("Wrong Choice! Enter Again!");
                    break;
            }
            System.out.print("Do you want to choose again? (y/n)? ");
            ch = sc.next().charAt(0);
        } while (ch == 'y');
        sc.close();
    }
}


class CalculatorHelper {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        return num1 / num2;
    }

    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double mean(double sum, int n) {
        return sum / n;
    }

    public double variance(double sum, int n) {
        return Math.sqrt(mean(sum, n));
    }
}