package com.lab.assignment2;
import java.util.ArrayList;
import java.util.List;

public class ArrayToArrayList {
    public static void main(String[] args) {
        String [] array = {"xyz", "abc", "pqr", "efg"};
        List<String> stringList = new ArrayList<String>();
        for (String text: array) {
            stringList.add(text);
        }
        System.out.print("The Array is: ");
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("The List is: ");
        System.out.println(stringList);
    }
}
