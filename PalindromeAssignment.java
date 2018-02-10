import java.util.Scanner;

/**
 * Created by Vibhanshu on 07/02/18.
 */
public class PalindromeAssignment {

    // using string and recursion
    // better and simplistic approach

    public static boolean IsPalindromeUsingString(String number) {
        if (number.length() == 0 || number.length() == 1) {
            return true;
        }

        if ((number.charAt(number.length() - 1)) == number.charAt(0)) {
            return IsPalindromeUsingString(number.substring(1, number.length() - 1));
        }

        return false;
    }

    // using array and while loop

    public static boolean IsPalindrome(int a) {
        int length = 0;
        int b = a;

        while (b != 0) {
            length++;
            b = b / 10;
        }

        int num[] = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = a % 10;
            a = a / 10;
        }

        int i = 0;

        while (i <= length) {
            if (num[i] == num[length - 1]) {
                i++;
                length--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b[] = new int[a];

        for(int i = 0; i < a; i++) {
            b[i] = s.nextInt();
        }

        for(int i = 0; i < a; i++) {
            int currentNumber = b[i] + 1;
            boolean answer = false;
            while (answer != true) {
                if (IsPalindrome(currentNumber)) {
                    answer = true;
                    System.out.println(currentNumber);
                } else {
                    currentNumber++;
                }

                if (IsPalindromeUsingString(String.valueOf(currentNumber))) {
                    answer = true;
                    System.out.println(currentNumber);
                } else {
                    currentNumber++;
                }
            }
        }

    }

}
