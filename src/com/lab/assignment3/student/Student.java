package com.lab.assignment3.student;

public class Student {
    private String name;
    private int prn;
    private float marks;
    private Dob dob;

    Student (String name, int prn, float marks) {
        this.name = name;
        this.prn = prn;
        this.marks = marks;
    }

    public void setDateOfBirth(int day, int month, int year) {
        dob = new Dob(day, month, year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }
}

class Dob {
    private int day;
    private int month;
    private int year;


    Dob (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay (int day) {
        this.day = day;
    }

    public void setMonth (int month) {
        this.month = month;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}