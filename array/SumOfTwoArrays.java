package array;

public class SumOfTwoArrays {

    public static int[] sumOfTwoArrays(int result){

        int length = Integer.toString(result).length();

        int[] resultArray = new int[length];

        for (int i = 0; i < length; i++){
            int temp = result / (int) Math.pow(10, length - 1 - i);
            temp = temp % 10;
            resultArray[i] = temp;
        }

        return resultArray;

    }

    public static void main(String[] args) {

        int[] array1 = {9,9,9};
        int[] array2 = {1};

        int length1 = array1.length;
        int length2 = array2.length;

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < length1; i++){
            num1 = num1 + array1[i] * (int) Math.pow(10, length1 - 1 - i);
        }

        for (int i = 0; i < length2; i++){
            num2 = num2 + array2[i] * (int) Math.pow(10, length2 - 1 - i);
        }

        int result = num1 + num2;

        for (int arr:sumOfTwoArrays(result)){
            System.out.print(arr + " ");
        }

    }

}
