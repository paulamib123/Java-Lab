package com.lab.assignment3.student;

import java.util.*;
import java.lang.Float;

public class StudentMain {

    public Student addStudent(String name, int prn, float marks, int day, int month, int year) {
        Student student = new Student(name, prn, marks);
        student.setDateOfBirth(day, month, year);
        return student;
    }

    public void display(Student obj) {
            Dob dob = obj.getDob();
            System.out.println("Student Name is: " + obj.getName());
            System.out.println("Student PRN is: " + obj.getPrn());
            System.out.println("Student Marks is: " + obj.getMarks());
            System.out.println("Student Birth Date is: " + dob.getDay() + "/" + dob.getMonth() + "/" + dob.getYear());
            System.out.println();
    }

    public Student searchByPRN(int prn, Student obj) {
            if (prn == obj.getPrn()) {
                return obj;
            } else {
                return null;
            }
    }

    public Student searchByName(String name, Student obj) {
        if (name.equals(obj.getName())) {
            return obj;
        } else {
            return null;
        }
    }

    public void updateName(String newName, int prn, Student obj) {
        Student student;
        student = searchByPRN(prn, obj);
        student.setName(newName);
    }

    public void updateMarks(float newMarks, int prn, Student obj) {
        Student student;
        student = searchByPRN(prn, obj);
        student.setMarks(newMarks);
    }

    public void delete(Student obj) {
        obj = null;
    }

    public String grade(Student obj) {
        float marks = obj.getMarks();
        if (marks >= 40 && marks <= 50) return "C";
        else if (marks > 50 && marks <= 60) return "B";
        else if (marks > 60  && marks <= 70) return "B+";
        else if (marks > 70  && marks <= 80) return "A";
        else if (marks > 80) return "A+";
        else return "F";
    }

    public static void main(String[] args) {
        int day;
        int month;
        int year;
        String name;
        int prn;
        float marks;
        char ch;
        int option;
        Student student = null;
        List<Student> list = new ArrayList<Student>();

        Scanner sc = new Scanner(System.in);
        StudentMain studentMain = new StudentMain();

        do {
            System.out.println("MENU");
            System.out.println("1. ADD STUDENTS");
            System.out.println("2. DISPLAY STUDENTS");
            System.out.println("3. SEARCH");
            System.out.println("4. UPDATE");
            System.out.println("5. DELETE");
            System.out.println("6. GRADES OF STUDENTS");
            System.out.println("7. SORT STUDENTS BY MARKS");

            int choice;
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    name = sc.next();

                    System.out.print("Enter Student PRN: ");
                    prn = sc.nextInt();

                    System.out.print("Enter Student marks: ");
                    marks = sc.nextFloat();

                    System.out.print("Enter Student Birth Date: ");
                    day = sc.nextInt();

                    System.out.print("Enter Student Birth Month: ");
                    month = sc.nextInt();

                    System.out.print("Enter Student Birth Year: ");
                    year = sc.nextInt();

                    student = studentMain.addStudent(name, prn, marks, day, month, year);
                    list.add(student);
                    break;

                case 2:
                    for (Student obj: list) {
                        studentMain.display(obj);
                    }
                    break;

                case 3:
                    student = null;
                    System.out.println("1. SEARCH BY PRN");
                    System.out.println("2. SEARCH BY NAME");
                    System.out.print("Choose option: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            System.out.print("Enter PRN: ");
                            prn = sc.nextInt();

                            for (Student obj : list) {
                                student = studentMain.searchByPRN(prn, obj);
                                if (student != null) {
                                    studentMain.display(student);
                                    break;
                                }
                            }

                            if (student == null) System.out.println("Invalid PRN!");
                            break;

                        case 2:
                            System.out.print("Enter Name: ");
                            name = sc.next();

                            for (Student obj : list) {
                                student = studentMain.searchByName(name, obj);
                                if (student != null) {
                                    studentMain.display(student);
                                    break;
                                }
                            }

                            if (student == null) System.out.println("Invalid Name!");
                            break;
                    }
                    break;

                case 4:
                    System.out.print("Enter PRN: ");
                    prn = sc.nextInt();

                    System.out.println("1. UPDATE NAME");
                    System.out.println("2. UPDATE MARKS");
                    System.out.print("Choose option: ");
                    option = sc.nextInt();
                    System.out.println();
                    switch (option) {
                            case 1:
                                for (Student obj : list) {
                                    student = studentMain.searchByPRN(prn, obj);
                                    if (student != null) {
                                        System.out.print("Enter new name: ");
                                        name = sc.next();
                                        studentMain.updateName(name, prn, obj);
                                        System.out.println("Updated Name");
                                        break;
                                    }
                                }

                                if (student == null) System.out.println("Invalid PRN!");
                                break;

                            case 2:
                                for (Student obj : list) {
                                    student = studentMain.searchByPRN(prn, obj);
                                    if (student != null) {
                                        System.out.print("Enter new marks: ");
                                        marks = sc.nextFloat();
                                        studentMain.updateMarks(marks, prn, obj);
                                        System.out.println("Updated Marks");
                                        break;
                                    }
                                }

                                if (student == null) System.out.println("Invalid PRN!");
                                break;
                        }
                    break;

                case 5:
                    System.out.print("Enter PRN: ");
                    prn = sc.nextInt();
                    for (Student obj : list) {
                        student = studentMain.searchByPRN(prn, obj);
                        if (student != null) {
                            studentMain.delete(obj);
                            System.out.println("Deleted record Successfully");
                            list.remove(student);
                            break;
                        }
                    }

                    if (student == null) System.out.println("Invalid PRN!");
                    break;

                case 6:
                    System.out.println("Name        Marks       Grade");
                    for (Student obj: list) {
                        String grade = studentMain.grade(obj);
                        System.out.println(obj.getName() + "        " + obj.getMarks() + "      " + grade);
                    }
                    break;

                case 7:
                    Collections.sort(list, new SortByMarks());
                    System.out.println("Sorted Records According to Marks");
            }
            System.out.print("Do you want to choose again? (y/n)? ");
            ch = sc.next().charAt(0);
            System.out.println();
        } while (ch == 'y');
    }

}

class SortByMarks implements Comparator<Student> {

    public int compare(Student a, Student b)
    {
        return Float.compare(a.getMarks(), b.getMarks());
    }
}