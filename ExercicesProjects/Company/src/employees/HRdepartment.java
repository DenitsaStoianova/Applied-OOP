package employees;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class HRdepartment {

    private Manager manager;
    private ArrayList<Staff> staff;

    public HRdepartment(Manager manager) {
        setManager(manager);
        staff = new ArrayList<>();
    }

    public Manager getManager() {
        return new Manager(manager);
    }

    public void setManager(Manager manager) {
        if(manager == null){
            throw new InvalidParameterException();
        } else {
            this.manager = new Manager(manager);
        }
    }

    private class AppointHandler implements StaffAppointHandler{
        private String appointDepartment;

        private AppointHandler(String appointDepartment){
            setAppointDepartment(appointDepartment);
        }

        public void setAppointDepartment(String appointDepartment) {
            if(appointDepartment == null){
                throw new InvalidParameterException();
            } else {
                this.appointDepartment = appointDepartment;
            }
        }


        @Override
        public void addStaff(StaffAppointEventArgs staffAppointEventArgs) {
            Staff staffToAppoint = staffAppointEventArgs.getStaff();
            staffToAppoint.setWorkAt(appointDepartment);
            staffToAppoint.setSalary(staffAppointEventArgs.getNewSalaryOfAppointed());

            staff.add(staffToAppoint);
        }

        @Override
        public String toString() {
            return String.format("Department name: %s%n%s", this.appointDepartment, HRdepartment.this.toString());
        }
    }

    public StaffAppointHandler getAppointHandler(){ // managera na otdela naznachava v svoq otdel
        return new AppointHandler(this.manager.getManageDeptName());
    }

    @Override
    public String toString() {
        String result = String.format("%s%n", this.manager);
        for(Staff s : staff){
            result += String.format("%s%n", s);
        }
        return result;
    }
}
