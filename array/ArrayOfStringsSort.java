package array;

public class ArrayOfStringsSort {

    public static String[] sortStrings(String[] str){

        for (int i = 0; i < str.length; i++){
            for (int j = 0; j < str.length - 1; j++){
                if (str[i].length() < str[j].length()){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        return str;

    }

    public static void main(String[] args) {

        String str[] = {"Hello", "my", "name", "is", "Mickey", "Mouse"};

        for (String s: sortStrings(str)){
            System.out.println(s);
        }

    }
}
