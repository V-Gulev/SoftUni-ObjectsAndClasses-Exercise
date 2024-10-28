package Articles_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(", ");
        String title = parts[0];
        String content = parts[1];
        String author = parts[2];
        Article article1 = new Article(title,content,author);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elements = sc.nextLine().split(": ");
            String command = elements[0];

            switch (command) {
                case "Edit":
                    article1.edit(elements[1]);
                    break;
                case "ChangeAuthor":
                    article1.changeAuthor(elements[1]);
                    break;
                case "Rename":
                    article1.rename(elements[1]);
                    break;
                default:
                    break;

            }
        }
        System.out.println(article1);

    }
}
