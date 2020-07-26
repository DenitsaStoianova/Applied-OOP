package employees;

public class Staff extends Employee {

    private String workAt;

    public Staff(String name, double salary, String workAt) {
        super(name, salary);
        setWorkAt(workAt);
    }

    public Staff(){
        this("No name", 1000, "Candidate");
    }

    public Staff(Staff staff){
        this(staff.getName(), staff.getSalary(), staff.workAt);
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

    @Override
    public String toString() {
        return String.format("Staff %s works at %s", super.toString(), this.workAt);
    }
}
