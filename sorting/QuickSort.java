package sorting;

public class QuickSort {

    public static int partition(int[] array, int left, int right){

        int i = left, j = right;
        int temp;
        int pivot = array[(left+right)/2];

        while (i <= j){
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }

    public static void quickSort(int[] array, int left, int right){

        int index = partition(array, left, right);
        if (left < index - 1)
            quickSort(array, left, index - 1);
        if (index < right)
            quickSort(array, index, right);

    }

    public static void main(String[] args) {

        int[] array = {4,2,5,7,1,3,9,6};

        quickSort(array, 0, array.length - 1);

        for (int i: array){
            System.out.println(i);
        }


    }

}
