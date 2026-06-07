package practise.leetCode;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private Department department;
    private int age;

    public Employee(int id, String name, double salary,
                    Department department, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", age=" + age +
                '}';
    }
}
