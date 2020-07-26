package employees;

import java.security.InvalidParameterException;

public class Manager extends Employee {

    private String manageDeptName;
    StaffAppointHandler staffAppoint;

    public Manager(String name, double salary, String manageDeptName) {
        super(name, salary);
        setManageDeptName(manageDeptName);
    }

    public Manager() {
        this("No name", 1000, "Unknown");
    }

    public Manager(Manager manager) {
        this(manager.getName(), manager.getSalary(), manager.manageDeptName);
    }

    public final String getManageDeptName() {
        return manageDeptName;
    }

    public final void setManageDeptName(String manageDeptName) {
        if (manageDeptName == null) {
            throw new InvalidParameterException();
        } else {
            this.manageDeptName = manageDeptName;
        }
    }

    void addStaffAppointHandler(StaffAppointHandler staffAppointHandler) {
        this.staffAppoint = staffAppointHandler;
    }

    void onStaffAppoint(Staff member, double newStaffMemberSalary) {
        if(staffAppoint != null) {
            StaffAppointEventArgs staffWithNewSalary = new StaffAppointEventArgs(member, newStaffMemberSalary);
            staffAppoint.addStaff(staffWithNewSalary);
        }
    }

    @Override
    public String toString() {
        return String.format("Manager %s works at %s", super.toString(), this.manageDeptName);
    }
}
