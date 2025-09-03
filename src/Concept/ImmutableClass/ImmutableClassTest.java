package Concept.ImmutableClass;

import java.time.LocalDate;
import java.util.Date;

public class ImmutableClassTest {
    public static void main(String[] args) {
        Date date = new Date();
        LocalDate lwd = LocalDate.now();

        Employee employee = new Employee(1, "ABC", date, lwd);
        Employee employee1 = new Employee(1, "ABC", date, lwd);
        Employee employee2 = new Employee(2, "ABC", date, lwd);
        System.out.println("employee : "+ employee);
        if (employee.getDoj() == date) {
            System.out.println("employee.getDoj() == date is same object");
        } else {
            System.out.println("employee.getDoj() == date is different object");
        }

        if (employee.getLwd() == lwd) {
            System.out.println("employee.getLwd() == lwd is same object");
        } else {
            System.out.println("employee.getLwd() == lwd is different object");
        }

        System.out.println("employee == employee1 : "+(employee == employee1));
        System.out.println("employee == employee2 : "+(employee == employee2));
        System.out.println("employee1 == employee2 : "+(employee1 == employee2));

        System.out.println("employee.equals(employee1) : "+employee.equals(employee1));
        System.out.println("employee.equals(employee2) : "+employee.equals(employee2));
        System.out.println("employee1.equals(employee2) : "+employee1.equals(employee2));

        System.out.println("employee hashCode : " + employee.hashCode());
        System.out.println("employee1 hashCode : " + employee1.hashCode());
        System.out.println("employee2 hashCode : " + employee2.hashCode());
    }
}
final class Employee {
    private final int id;
    private final String name;
    private final Date doj;

    private final LocalDate lwd;

    public Employee(int id, String name, Date doj, LocalDate lwd) {
        this.id = id;
        this.name = name;
        // deep copy of the object
        long millis = doj.getTime();
        Date date = new Date(millis);
        this.doj = doj != null ? date : null;

        // deep copy of the localDate;
        String mod = lwd.toString();
        LocalDate last = LocalDate.parse(mod);
        this.lwd = last;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getDoj() {
        // deep copy of the object
        long millis = doj.getTime();
        Date date = new Date(millis);
        return this.doj != null ? date : null;
    }

    public LocalDate getLwd() {
        String mod = lwd.toString();
        LocalDate last = LocalDate.parse(mod);
        return last;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + id;
        result = result + (name!= null ? name.hashCode(): 0);
        result = result + (doj != null ? doj.hashCode() : 0);
        result = result + (lwd != null ? lwd.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Employee emp = (Employee) obj;
        return this.id == emp.id && this.name.equals(emp.name) && this.doj.equals(emp.doj) && this.lwd.equals(emp.lwd);
    }

    @Override
    public String toString() {
        return "Employee{ id = "+this.id + ", name = " + this.name + ", doj = "+ this.doj+
                ", lwd = "+this.lwd;
    }

}
