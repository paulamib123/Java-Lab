package com.lab.assignment1;
import java.util.Scanner;

class MenuDriven {
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1)
            return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        char ch;
        do {
            System.out.println("MENU");
            System.out.println("1. FACTORIAL");
            System.out.println("2. FIBONACCI");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: 
                    System.out.print("Enter number for factorial: ");
                    num = sc.nextInt();
                    System.out.println("Factorial of " + num + " is " + factorial(num));
                    break;

                case 2: 
                    System.out.print("Enter number of elements for fibonacci series: ");
                    num = sc.nextInt();
                    for (int i = 0; i < num; i++) {
                        System.out.print(fibonacci(i) + " ");
                    }
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