package model;

public class Employee {

    public final String ID;
    private static int cnt = 1;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
        ID = String.format("E-%03d", cnt++);
    }

    public Employee() {
        this("No name", 1000);
    }

    public Employee(Employee employee) {
        this(employee.name, employee.salary);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if(name == null){
            this.name = "No name";
        } else {
            this.name = name;
        }
    }

    public final double getSalary() {
        return salary;
    }

    public final void setSalary(double salary) {
        if(salary < 0){
            this.salary = 1000;
        } else {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f",this.ID, this.name, this.salary);
    }
}
