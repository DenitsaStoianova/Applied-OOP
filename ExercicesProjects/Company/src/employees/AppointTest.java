package employees;

public class AppointTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Ivan", 80_000, "Invoices");

        Staff[] candidates = new Staff[]{
                new Staff("Georgi", 200, "Business"),
                new Staff("Henry", 600, "IT")
        };

        System.out.println(boss);

        System.out.println("Candidates before appointment:");
        for (Staff staff : candidates) {
            System.out.println(staff);
        }

        HRdepartment hRdepartment = new HRdepartment(boss); // Invoice

        StaffAppointHandler sah = hRdepartment.getAppointHandler();

        boss.addStaffAppointHandler(sah);
        boss.onStaffAppoint(candidates[0], 1300);
        boss.onStaffAppoint(candidates[1], 1500);

        System.out.println("\nAppointed:");
        System.out.println(sah.toString());

        System.out.println("Candidates after appointment:");
        for (Staff staff : candidates) {
            System.out.println(staff);
        }
    }
}
