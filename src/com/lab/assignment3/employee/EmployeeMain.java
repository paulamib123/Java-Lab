package com.lab.assignment3.employee;

import java.util.*;

public class EmployeeMain {
    static int count = 0;

    public static int countInstance() {
        return count;
    }

    public Employee addEmployee(int id, String name, String gender, String jobTitle, String company, int salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setGender(gender);
        employee.setJobTitle(jobTitle);
        employee.setCompany(company);
        employee.setSalary(salary);
        count++;
        return employee;
    }

    public void deleteEmployee(Employee employee) {
        employee = null;
        count--;
    }

    public Employee searchByName(Employee employee, String name) {
        if (name.equals(employee.getName()))
            return employee;
        return null;
    }

    public Employee searchById(Employee employee, int id) {
        if (id == employee.getId())
            return employee;
        return null;
    }

    public int compareBySalary(Employee a, Employee b) {
        if (a.getSalary() > b.getSalary())
            return 1;
        if (b.getSalary() > a.getSalary())
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        int choice;
        int id;
        String name;
        String gender;
        String jobTitle;
        String company;
        int salary;
        char ch;
        int answer = 0;

        Vector<Employee> list = new Vector<Employee>();
        EmployeeMain employeeMain = new EmployeeMain();
        Employee employee = null;
        Employee employee1 = null;
        Employee employee2 = null;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("MENU");
            System.out.println("1. ADD EMPLOYEE");
            System.out.println("2. DISPLAY DATA");
            System.out.println("3. SEARCH BY ID");
            System.out.println("4. SEARCH BY NAME");
            System.out.println("5. DELETE");
            System.out.println("6. COMPARE BY SALARY");
            System.out.println("7. SORT BY NAME");
            System.out.print("\n" + "Choose any option: ");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Employee Name: ");
                    name = sc.next();
                    System.out.print("Enter Employee Gender: ");
                    gender = sc.next();
                    System.out.print("Enter Employee Job Title: ");
                    jobTitle = sc.next();
                    System.out.print("Enter Employee's Organization: ");
                    company = sc.next();
                    System.out.print("Enter Employee Salary: ");
                    salary = sc.nextInt();

                    employee = employeeMain.addEmployee(id, name, gender, jobTitle, company, salary);
                    list.add(employee);

                    break;

                case 2:
                    if (list.size() == 0) {
                        System.out.println("No Data found!");
                    } else {
                        for (Employee emp : list) {
                            emp.display();
                            System.out.println();
                        }
                    }

                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    for (Employee emp: list) {
                        employee = employeeMain.searchById(emp, id);
                        if (employee != null) {
                            emp.display();
                            break;
                        }
                    }

                    if (employee == null)
                    System.out.println("ID Does Not Exist!");
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    name = sc.next();

                    for (Employee emp: list) {
                        employee = employeeMain.searchByName(emp, name);
                        if (employee != null) {
                            emp.display();
                            break;
                        }
                    }
                    if (employee == null)
                    System.out.println("Name Does Not Exist!");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    for (Employee emp: list) {
                        employee = employeeMain.searchById(emp, id);
                        if (employee != null) {
                            employeeMain.deleteEmployee(employee);
                            System.out.println("Deleted Successfully");
                            list.remove(employee);
                            break;
                        }
                    }

                    if (employee == null)
                        System.out.println("ID Does Not Exist!");
                    break;

                case 6:
                    System.out.print("Enter ID for employee 1: ");
                    id = sc.nextInt();

                    for (Employee emp: list) {
                        employee1 = employeeMain.searchById(emp, id);
                        if (employee1 != null) {
                            break;
                        }
                    }

                    System.out.print("Enter ID for employee 2: ");
                    id = sc.nextInt();

                    for (Employee emp: list) {
                        employee2 = employeeMain.searchById(emp, id);
                        if (employee2 != null) {
                            break;
                        }
                    }

                    if (employee2 == null || employee1 == null)
                        System.out.println("ID Does Not Exist!");
                    else
                        answer = employeeMain.compareBySalary(employee1, employee2);
                        if (answer == 1) System.out.println("\nEmployee1's Salary is greater than Employee2");
                        else if (answer == -1) System.out.println("\nEmployee2's Salary is greater than Employee1");
                        else if (answer == 0) System.out.println("\nBoth have same salaries");
                    break;

                case 7:
                    Collections.sort(list, new SortByName());
                    System.out.println("Press Display to see data in sorted order");
                    break;
            }

            System.out.println();
            System.out.print("Do you want to choose again? (y/n)? ");
            ch = sc.next().charAt(0);

        } while (ch == 'y');

    }

}

class SortByName implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return a.getName().compareTo(b.getName());
    }
}


