package OrderByAge_06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<People> people = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] parts = input.split(" ");
            String name = parts[0];
            String id = parts[1];
            int age = Integer.parseInt(parts[2]);
            People person = new People(name, id, age);
            people.add(person);
        }

        people.sort(Comparator.comparing(People::getAge));

        for (People person : people) {
            System.out.println(person);
        }
    }
}
