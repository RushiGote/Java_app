import java.util.Scanner;

public class PFCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get employee details
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        // PF is calculated on a max of ₹15,000 unless full salary is considered
        double pfLimit = 15000;
        double pfSalary = Math.min(basicSalary, pfLimit);

        // PF = 12% of basic salary
        double employeePF = pfSalary * 0.12;
        double employerPF = pfSalary * 0.12;
        double totalPF = employeePF + employerPF;

        // Display results
        System.out.println("\n----- PF Details -----");
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: ₹" + basicSalary);
        System.out.println("PF Salary Considered: ₹" + pfSalary);
        System.out.println("Employee PF (12%): ₹" + employeePF);
        System.out.println("Employer PF (12%): ₹" + employerPF);
        System.out.println("Total PF Contribution: ₹" + totalPF);
    }
}
//Thank You
