package array;

import java.util.HashMap;
import java.util.Iterator;

public class FindDuplicateElements {

    // find duplicates in an array, uses O(n) complexity

    public static void findDuplicates(int[] result){

        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max){
                max = result[i];
            }
        }

        int[] arr = new int[max+1];

        for (int i = 0; i < result.length; i++) {
            if (arr[result[i]] == 0) {
                arr[result[i]] = result[i];
            } else {
                arr[result[i]] = -1 * arr[result[i]];
            }
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                System.out.println(Math.abs(arr[i]));
            }
        }
    }

    // better appraoch to find duplicates in an array, uses hashmaps

    public static void findDuplicatesBetter(int[] result){

        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i: result){
            if (!map.containsKey(i)){
                map.put(i, false);
            } else {
                map.put(i, true);
            }
        }

        Iterator<Integer> keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            if (map.get(key) == true)
                System.out.println(key);
        }

    }

    public static void main(String[] args) {

        int[] array = {11,12,13,14,20,11,16,17,20,18};

        findDuplicates(array);
        findDuplicatesBetter(array);

    }

}
