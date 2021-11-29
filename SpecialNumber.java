import java.util.Scanner;

/**
 * Enter n to return the nth Palindromic number which only contains 2,3 and 4
 * digits
 */
public class SpecialNumber {
    static String solve(int n) {
        // required digits
        char digit2 = '2';

        // the length of half of the desired String
        int halfLength = (int) Math.ceil(Math.log(2 * n + 3.0) / Math.log(3)) - 1;

        // index of number n
        int index = n - ((int) (Math.pow(3, halfLength) - 3) / 2) - 1;

        StringBuilder left = new StringBuilder();

        // the beginning of k-digit numbers is always 222...222
        for (int i = halfLength; i > 0; i--) {
            left.append(digit2);
        }

        long leftNumber = Long.parseLong(left.toString()) + convertToTernary(index);

        left = new StringBuilder(String.valueOf(leftNumber));

        StringBuilder right = new StringBuilder(left);

        return left.append(right.reverse().toString()).toString();
    }

    static long convertToTernary(int num) {
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % 3 * factor;
            num /= 3;
            factor *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();

        System.out.println(solve(n));

    }
}
