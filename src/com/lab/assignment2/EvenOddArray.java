package com.lab.assignment2;
import java.util.Scanner;

public class EvenOddArray {
    private int j = 0;
    private int k = 0;

    private void evenOdd(int num, int[] even, int[] odd) {
        if (num % 2 == 0) {
            even[j++] = num;
        } else {
            odd[k++] = num;
        }
    }

    public static void main(String[] args) {
        int num;
        int n;
        int[] odd = new int[100];
        int[] even = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers do you want to enter? ");
        n = sc.nextInt();
        EvenOddArray evenOddArray = new EvenOddArray();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Number " + i + " : ");
            num = sc.nextInt();
            evenOddArray.evenOdd(num, odd, even);
        }

        System.out.print("Elements in Odd Array: ");
        for (int i = 0; odd[i] != 0; i++) {
            System.out.print(odd[i] + " ");
        }

        System.out.println();
        System.out.print("Elements in Even Array: ");
        for (int i = 0; even[i] != 0; i++) {
            System.out.print(even[i] + " ");
        }
    }
}
