import java.util.*;

public class Main {

    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = -1;
        }

        public Employee(String name, double salary, String position, String department, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = age;
        }

        public Employee(String name, double salary, String position,String department) {
            this.department = department;
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.email = "n/a";
            this.age = -1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public String toString() {
            return String.format("%s %.2f %s %d", name, salary, email, age);
        }
    }
    static class Department {
        String name;
        List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        public double getAverageSalary() {
            return employees.stream().mapToDouble(e -> e.salary).average().orElse(0.0);
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();
        Employee employee;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 4) {
                employee = new Employee(name,salary,position,department);
            } else if (input.length == 5) {
                String data = input[4];
                if (Character.isDigit(data.charAt(0))) {
                    employee = new Employee(name, salary,position,department,Integer.parseInt(data));
                } else {
                    employee = new Employee(name, salary, position, department, data);
                }
            } else {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name,salary,position,department,email,age);
            }

            Department departmentType = findDepartment(departments, department);
            if (departmentType == null) {
                departmentType = new Department(department);
                departments.add(departmentType);
            }

            departmentType.addEmployee(employee);

        }

        Department MaxAverageSalary = departments.stream()
                .max(Comparator.comparing(Department::getAverageSalary))
                .orElse(null);

        if (MaxAverageSalary != null) {
            System.out.println("Highest Average Salary: " + MaxAverageSalary.name);
            MaxAverageSalary.getEmployees().stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .forEach(System.out::println);
        }
    }
    public static Department findDepartment(List<Department> departments, String name) {
        for (Department department : departments) {
            if (department.name.equals(name)) {
                return department;
            }
        }
        return null;
    }
}
