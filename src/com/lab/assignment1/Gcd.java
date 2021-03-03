package com.lab.assignment1;
import java.util.Scanner;

class Gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number a: ");
        int a = sc.nextInt();
        System.out.print("Enter number b: ");
        int b = sc.nextInt();
        System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
        sc.close();
    }
}