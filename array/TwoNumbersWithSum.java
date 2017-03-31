package array;

import java.util.Arrays;

public class TwoNumbersWithSum {

    public static boolean twoNumbersExistsWithSum(int array[], int number){

        for (int i=0; i<array.length; i++) {
            int diff = number - i;
            for (int j=0; j<array.length; j++){
                if (array[j] == diff) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int array[] = {1,2,3,4,5,6,7,8};
        int number = 9;

        System.out.println(twoNumbersExistsWithSum(array, number));

    }

}
