import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(Factorial(num));
    }

    public static BigInteger Factorial(int num) {
        if (num == 0 || num == 1) {
            return BigInteger.valueOf(1);
        } else {
            BigInteger sum = new BigInteger(String.valueOf(1));
            for (int i = 2; i <= num ; i++) {
                sum = sum.multiply(BigInteger.valueOf(i));
            }
            return sum;
        }

    }
}
