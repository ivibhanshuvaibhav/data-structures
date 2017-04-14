public class Strings {

    // remove consective duplicates from a string

    public static String removeConsecutiveDuplicates(String str){

        if(str.length() == 0 || str.length() == 1){
            return str;
        }

        if(str.charAt(0) == str.charAt(1)){
            return removeConsecutiveDuplicates(str.substring(1));
        }

        return str.charAt(0) + removeConsecutiveDuplicates(str.substring(1));

    }

    // find minimum length word in a string

    public static String smallestWord(String str){

        String[] words = str.split(" ");

        String s = words[0];
        int len = s.length();


        for (int i=1; i<words.length; i++){
            if(len > words[i].length()){
                len = words[i].length();
                s = words[i];
            }
        }

        return s;
    }

    // print all permutations of a string

    public static void stringSubsequences(String str){

        int len = str.length();

        for(int j = 0; j < len; j++) {

            for (int i = len; i > j; i--) {

                System.out.println(str.substring(j, i));

            }
        }

    }

    public static void main(String[] args) {

        System.out.println(removeConsecutiveDuplicates("aaabbbccbbbccbbbaaa"));
        System.out.println(smallestWord("This is an example of string"));
        stringSubsequences("abcd");

    }

}