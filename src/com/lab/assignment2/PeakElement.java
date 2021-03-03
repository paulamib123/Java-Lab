package com.lab.assignment2;
import java.util.Scanner;

public class PeakElement {

    private static int peakElement(int [] arr) {
        int n = arr.length;

        if (n == 1) return 0;

        if (arr[0] >= arr[1])  // case for left corner element
            return arr[0];

        if (arr[n - 1] >= arr[n - 2])  // case for right corner element
            return arr[n - 1];

        for (int i = 1; i <= n - 2; i++) {
            if (arr[i - 1] < arr[i]  && arr[i + 1] < arr[i]) {
                return arr[i];
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        size = sc.nextInt();

        int [] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr[i] = sc.nextInt();
        }

        int peak = peakElement(arr);
        System.out.println("The peak element is: " + peak);
    }
}
