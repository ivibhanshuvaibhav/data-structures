package sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = {4,2,5,7,1,3,9,6};

        for (int i: bubbleSort(array)){
            System.out.println(i);
        }

    }

}
