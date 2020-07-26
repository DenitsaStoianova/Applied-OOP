package model;

import java.util.function.BiConsumer;

public class Manager extends Employee {

    private BiConsumer<Staff,Double> appointRule;

    public Manager(String name, double salary, BiConsumer<Staff, Double> appointRule) {
        super(name, salary);
        setAppointRule(appointRule);
    }

    public Manager(Manager manager) {
        this(manager.getName(), manager.getSalary(), manager.appointRule);
    }

    public final void setAppointRule(BiConsumer<Staff, Double> appointRule) {
        if(appointRule == null){
            this.appointRule = null;
        } else {
            this.appointRule = appointRule;
        }
    }

    public void onStaffAppointment(Staff member, Double newStaffMemberSalary){
        if(appointRule != null) {
            appointRule.accept(member, newStaffMemberSalary);
        }
    }

}
