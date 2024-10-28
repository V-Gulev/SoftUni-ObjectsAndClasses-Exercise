package Students_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] elements = sc.nextLine().split(" ");
            String firstName = elements[0];
            String lastName = elements[1];
            double grade = Double.parseDouble(elements[2]);
            Students student = new Students(firstName, lastName, grade);
            students.add(student);
        }

        students.sort(Comparator.comparing(Students::getGrade));
        Collections.reverse(students);
        for (Students student : students) {
            System.out.println(student);
        }
    }
}
