package model;

import java.time.LocalDate;

public class Staff extends Employee {

    private String workAt;
    private LocalDate hiredAt;

    public Staff(String name, double salary, String workAt, LocalDate hiredAt) {
        super(name, salary);
        setWorkAt(workAt);
        setHiredAt(hiredAt);
    }

    public Staff(Staff staff) {
        this(staff.getName(), staff.getSalary(), staff.workAt, staff.hiredAt);
    }

    public final String getWorkAt() {
        return workAt;
    }

    public final void setWorkAt(String workAt) {
        if(workAt == null){
            this.workAt = "Candidate";
        } else {
            this.workAt = workAt;
        }
    }

    public final LocalDate getHiredAt() {
        return hiredAt;
    }

    public final void setHiredAt(LocalDate hiredAt) {
        if(hiredAt == null){
            this.hiredAt = LocalDate.now();
        } else {
            this.hiredAt = hiredAt;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", super.toString(), this.workAt, this.hiredAt);
    }
}
