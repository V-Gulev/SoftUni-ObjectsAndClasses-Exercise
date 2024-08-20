import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int random = rnd.nextInt(words.length);
            String temporary = words[i];
            words[i] = words[random];
            words[random] = temporary;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
