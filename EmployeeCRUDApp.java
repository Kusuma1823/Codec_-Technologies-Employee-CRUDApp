
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

class Employee {
    private int employeeNumber;
    private String employeeName;
    private int salary;

    public Employee(int employeeNumber, String employeeName, int salary) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee Number: " + employeeNumber + ", Name: " + employeeName + ", Salary: " + salary;
    }
}

public class EmployeeCRUDApp {
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Insert new Employee");
            System.out.println("2. Display all Employees");
            System.out.println("3. Search Employee by Employee Number");
            System.out.println("4. Delete Employee by Employee Number");
            System.out.println("5. Update Employee by Employee Number");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Number: ");
                    int empNo = scInt.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String empName = scStr.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    int empSalary = scInt.nextInt();

                    Employee emp = new Employee(empNo, empName, empSalary);
                    employees.add(emp);
                    System.out.println("Employee Added Successfully.");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("Employee List:");
                        Iterator<Employee> itr = employees.iterator();
                        while (itr.hasNext()) {
                            System.out.println(itr.next());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee Number to search: ");
                    int searchEmpNo = scInt.nextInt();
                    boolean found = false;
                    for (Employee e : employees) {
                        if (e.getEmployeeNumber() == searchEmpNo) {
                            System.out.println("Employee Found: " + e);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee Number to delete: ");
                    int delEmpNo = scInt.nextInt();
                    Iterator<Employee> delItr = employees.iterator();
                    boolean deleted = false;
                    while (delItr.hasNext()) {
                        Employee e = delItr.next();
                        if (e.getEmployeeNumber() == delEmpNo) {
                            delItr.remove();
                            System.out.println("Employee Deleted Successfully.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Record Not Found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee Number to update: ");
                    int updEmpNo = scInt.nextInt();
                    ListIterator<Employee> listItr = employees.listIterator();
                    boolean updated = false;
                    while (listItr.hasNext()) {
                        Employee e = listItr.next();
                        if (e.getEmployeeNumber() == updEmpNo) {
                            System.out.print("Enter new Employee Name: ");
                            String newName = scStr.nextLine();
                            System.out.print("Enter new Employee Salary: ");
                            int newSalary = scInt.nextInt();

                            Employee updatedEmp = new Employee(updEmpNo, newName, newSalary);
                            listItr.set(updatedEmp);
                            System.out.println("Employee Updated Successfully.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Record Not Found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scInt.close();
        scStr.close();
    }
}
