package array;

import java.util.Arrays;

public class ArrayIntersection {

    public static int[] arrayIntersection(int[] array1, int[] array2){

        int length1 = array1.length;
        int length2 = array2.length;

        int min = Math.min(length1, length2);

        int[] array = new int[min];
        int count = 0;

        for (int i = 0; i < length1; i++){
            for (int j = 0; j < length2; j++){
                if (array1[i] == array2[j]){
                    array[count] = array1[i];
                    count++;
                }
            }
        }

        array = Arrays.copyOfRange(array, 0, count);
        return array;

    }

    public static void main(String[] args) {

        int[] array1 = {1,2,4,9};
        int[] array2 = {2,4,7,9};

        for (int arr: arrayIntersection(array1, array2)){
            System.out.println(arr);
        }

    }
}
