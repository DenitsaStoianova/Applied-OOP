package employees;

public class StaffAppointEventArgs {
    private Staff staffToAppoint;
    private double newSalaryOfAppointed;

    public StaffAppointEventArgs(Staff staffToAppoint, double newSalaryOfAppointed) {
        setStaff(staffToAppoint);
        setNewSalaryOfAppointed(newSalaryOfAppointed);
    }

    public Staff getStaff() {
        return new Staff(staffToAppoint);
    }

    public void setStaff(Staff staff) {
        if(staff == null){
            this.staffToAppoint = new Staff();
        } else {
            this.staffToAppoint = new Staff(staff);
        }
    }

    public double getNewSalaryOfAppointed() {
        return newSalaryOfAppointed;
    }

    public void setNewSalaryOfAppointed(double newSalaryOfAppointed) {
        if(newSalaryOfAppointed < 0){
            this.newSalaryOfAppointed = 0;
        } else {
            this.newSalaryOfAppointed = newSalaryOfAppointed;
        }
    }
}
