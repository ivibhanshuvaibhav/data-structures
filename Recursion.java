public class Recursion {

    // find if a string is palindrome or not, using recursion

    public static boolean isPalindromeRecursively(String string){

        if(string.length() == 0 || string.length() == 1){
            return true;
        }

        if(string.charAt(0) == string.charAt(string.length() - 1)){
            return isPalindromeRecursively(string.substring(1, string.length() - 1));
        }

        return false;

    }

    // find if a string is palindrome or not, using iteration

    public static boolean isPalindromeIteratively(String string){

        int startIndex = 0;
        int endIndex = string.length() - 1;

        while(startIndex < endIndex) {
            if (string.charAt(startIndex) == string.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }

    // replace pi with 3.14 in every appearance in a string recursively

    public static String replacePi(String string){

        if(string == ""){
            return string;
        }

        if(string.length() == 0 || string.length() == 1){
            return string;
        }

        if(string.charAt(0) == 'p' && string.charAt(1) == 'i'){
            return "3.14" + replacePi(string.substring(2));
        }

        return string.charAt(0) + replacePi(string.substring(1));
    }

    // remove every occurence of x from a string recursively

    public static String noX(String string){

        if(string == ""){
            return string;
        }

        if(string.length() == 1){
            if(string.equals("x")){
                return "";
            }else{
                return string;
            }
        }

        if(string.charAt(0) == 'x'){
            return noX(string.substring(1));
        }

        return string.charAt(0) + noX(string.substring(1));

    }

    // separate identical adjacent characters with * recursively

    public static String pairStar(String string){

        if (string.length() == 0 || string.length() == 1){
            return string;
        }

        if (string.charAt(0) == string.charAt(1)){
            return string.charAt(0) + "*" + pairStar(string.substring(1));
        }

        return string.charAt(0) + pairStar(string.substring(1));

    }

    // Given two Strings check if one is reverse of the other

    public static boolean checkReverse(String str1, String str2){

        if(str1 == "" && str2 == ""){
            return true;
        }

        if(str1.length() != str2.length()){
            return false;
        }

        if(str1.equals(str2)){
            return true;
        }

        int length = str1.length();

        if(str1.charAt(0) == str2.charAt(length-1)){
            return checkReverse(str1.substring(1, length-1), str2.substring(1,length-1));
        }

        return false;

    }

    // recursive function to find the sum of the digits of an integer

    public static int sumOfDigits(int num){

        if (num == 0){
            return 0;
        }

        return num % 10 + sumOfDigits(num / 10);

    }

    // sum of digits using iteration

    public static int sumOfDigitsIteration(int number){

        int sum = 0;

        while (number != 0){

            sum += number%10;
            number = number/10;

        }

        return sum;

    }

    // count number of zero in an integer using recursion

    public static int countZero(int number){

        if(number == 0)
            return 0;

        if(number % 10 == 0){
            return 1 + countZero(number / 10);
        }

        return countZero(number / 10);

    }

    // count number of zero in an integer using recursion

    public static int countZeroIteration(int number){

        int count = 0;

        while (number != 0){

            if(number % 10 == 0){
                count++;
            }

            number = number/10;

        }

        return count;

    }

    // multiply two numbers iteratively using and and subtract

    public static int multiply(int num1, int num2){

        if(num1 == 0 || num2 == 0){
            return 0;
        }

        int i = 1;
        int sum = 0;

        while(i <= num2){

            sum += num1;
            i++;

        }

        return sum;

    }

    // multiply two numbers recursion using and and subtract

    public static int multiplyRecusively(int num1, int num2){

        if (num1 == 0 || num2 == 0){
            return 0;
        }

        if(num1 < num1){
            multiplyRecusively(num2, num1);
        }

        return num1 + multiplyRecusively(num1, num2 - 1);

    }

    // Given k find the geometric Sum i.e. 1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)

    public static double geometricSum(int k){

        if(k == 0){
            return 1;
        }

        return 1/Math.pow(2,k) + geometricSum(k-1);

    }

    

    public static void main(String[] args) {

        String str = "abcghcba";
        String str1 = "abcdcba";

        System.out.println(isPalindromeRecursively(str));
        System.out.println(isPalindromeIteratively(str1));

        int number = 20103000;
        System.out.println(countZero(number));
        System.out.println(countZeroIteration(number));

        System.out.println(replacePi("xpix"));
        System.out.println(replacePi("pipi"));
        System.out.println(replacePi("pip"));
        System.out.println(replacePi(""));

        System.out.println(noX("xaxb"));
        System.out.println(noX("abc"));
        System.out.println(noX("xx"));
        System.out.println(noX(""));

        System.out.println(pairStar("hello"));
        System.out.println(pairStar("xxyy"));
        System.out.println(pairStar("aaaa"));


        System.out.println(checkReverse("abcde", "edcba"));

        System.out.println(sumOfDigits(1234567891));
        System.out.println(sumOfDigitsIteration(1234567891));

        System.out.println(multiply(90,101));
        System.out.println(multiplyRecusively(50,50));

        System.out.println(geometricSum(5));

    }

}