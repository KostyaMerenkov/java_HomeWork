package HW5;

public class Employees {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employees(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo() {
        System.out.printf("Name: %s\nPosition: %s\nEmail: %s\nPhone: %s\nSalary: %d\nAge: %d\n\n", name, position, email, phone, salary, age);
    }

    public int getAge() {
        return age;
    }
}
