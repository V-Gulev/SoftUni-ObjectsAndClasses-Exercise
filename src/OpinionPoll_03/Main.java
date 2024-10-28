package OpinionPoll_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<OpinionPoll> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();

            if (age > 30) {
                OpinionPoll person = new OpinionPoll(name, age);
                people.add(person);
            }
        }
        for (OpinionPoll currentPerson : people) {
            System.out.println(currentPerson.getName() + " - " + currentPerson.getAge());
        }
    }
}
