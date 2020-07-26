package model;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Department {
    private Manager manager;
    private String deptName;
    private ArrayList<Staff> staff;

    public BiConsumer<Staff,Double> appointmentHandler = (worker, workerSalary) -> {
        worker.setWorkAt(deptName);
        worker.setHiredAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };

    public Department(Manager manager, String deptName) {
        setManager(manager);
        setDeptName(deptName);
        this.staff = new ArrayList<>();
    }

    public final void setManager(Manager manager) {
        if(manager == null){
            throw new InvalidParameterException("Cannot be null");
        } else {
            this.manager = new Manager(manager);
        }
    }

    public final void setDeptName(String deptName) {
        if(deptName == null){
            throw new InvalidParameterException("Cannot be null");
        } else {
            this.deptName = deptName;
        }
    }

    public final ArrayList<Staff> getStaff() {
        return new ArrayList<>(staff);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", manager, deptName, staff);
    }
}
