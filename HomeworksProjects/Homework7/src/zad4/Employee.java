/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


class Employee {

    public static enum Gender {
        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    //уникален идентификационен код за всеки обект от class Employee
    private UUID employeeID;

    private Employee(String name, Gender gender, LocalDate dob, double income) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        this.employeeID = UUID.randomUUID();
    }

    public Employee() {
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Employee)){
            return false;
        }

        return this.employeeID.equals(((Employee) obj).employeeID);
    }

    @Override
    public int hashCode(){
        return employeeID.hashCode();
    }

    @Override
    public String toString() {
        return String.format("EmployeeID: %s, Name: %s, Gender: %s, Date: %s, Income: %.2f", employeeID, name, gender, dob, income);
    }

    // метод, който пресмята и отпечатва сумата от доходите (income) на списъка от служители,
    // генериран с метода persons() на class Employee
    public static void statistics(){
        System.out.print("\nEmployees statistics: ");
        System.out.println(persons().stream()
                .mapToDouble(Employee::getIncome)
                .sum());
    }

    // метод, който групира по данната gender списъка от служители Employee , върнат от статичния
    // метод persons() на class Employee и за всяка група пресмята броя на служителите в групата,
    // извежда имената на групите и броя на служителите от всяка група.
    public void personsStatsByGenderCount(){
        System.out.println("\nCount of employees, grouped by gender:");
        Map<Employee.Gender, Long> groupedByGender = persons().stream()
                .collect(Collectors.groupingBy(x -> x.gender, Collectors.counting()));
        groupedByGender.forEach((gender, count) -> System.out.printf("%s employees have count %d%n", gender, count));
    }

    // метод, който групира по данната gender списъка от служители Employee , върнат от статичния
    // метод persons() на class Employee,
    // извежда имената на групите и служителите по групи
    public void personsStatsByGenderList(){
        System.out.println("\nList of employees, grouped by gender:");
        Map<Employee.Gender, List<Employee>> groupedByGender = persons().stream()
                .collect(Collectors.groupingBy(x -> x.gender));
        groupedByGender.forEach((gender, employeesWithGender) -> {
            System.out.printf("%s employees: %n", gender);
            employeesWithGender.forEach(System.out::println);
        });
    }

    public void printPersons(){
        System.out.println("Employees info:");
        persons().forEach(System.out::println);
    }
}

