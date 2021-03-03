package com.lab.assignment2;
import java.util.Scanner;

public class LargestAndSmallest {
    private static int difference (int [] arr) {
        int largest = arr[0];
        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0]) largest = arr[i];
            if (arr[i] < arr[0]) smallest = arr[i];
        }
        System.out.println("Largest is: " + largest);
        System.out.println("Smallest is: " + smallest);
        return largest - smallest;

    }

    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        size = sc.nextInt();
        while (size <= 1) {
            System.out.println("Please enter size greater than 1");
            System.out.print("Enter size of array again: ");
            size = sc.nextInt();
        }

        int [] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr[i] = sc.nextInt();
        }
        int diff = difference(arr);
        System.out.println("Difference between smallest and largest value is: " + diff);
    }
}
