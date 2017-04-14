package array;

import java.util.Arrays;

public class NumberPalindrome {

    public static boolean checkPalindrome(int num){

        int length = 0;
        int temp = num;

        while (temp != 0){
            length++;
            temp = temp/10;
        }

        int[] arr = new int[length];
        int index = 0;

        while (num != 0){
            arr[index] = num % 10;
            index++;
            num = num/10;
        }

        return checkArray(arr);
    }

    public static boolean checkArray(int[] arr){

        int len = arr.length;

        if (len == 0 || len == 1){
            return true;
        }

        if (arr[0] == arr[len - 1]){
            arr = Arrays.copyOfRange(arr, 1, len - 1);
            return checkArray(arr);
        }

        return false;
    }

    public static boolean checkPalindromeBetter(int num){

        String str = Integer.toString(num);

        char[] arr = str.toCharArray();

        return checkArrayBetter(arr);

    }

    public static boolean checkArrayBetter(char[] arr){

        int len = arr.length;

        if (len == 0 || len == 1){
            return true;
        }

        if (arr[0] == arr[len - 1]){
            arr = Arrays.copyOfRange(arr, 1, len - 1);
            return checkArrayBetter(arr);
        }

        return false;
    }

    public static void main(String[] args) {

        int a = 323;
        int b = 123474321;

        System.out.println("Number: " + a + " Is Palindrome? " + checkPalindrome(a));
        System.out.println("Number: " + b + " Is Palindrome? " + checkPalindrome(b));
        System.out.println("Number: " + a + " Is Palindrome? " + checkPalindromeBetter(a));
        System.out.println("Number: " + b + " Is Palindrome? " + checkPalindromeBetter(b));

    }

}
