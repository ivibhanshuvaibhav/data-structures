package stack;

public class BalancedParenthesis {

    // check if an expression is balanced or not

    public static boolean isBalanced(String input){

        StackUsingArray s = new StackUsingArray();

        for(int i = 0; i<input.length(); i++) {
            int currentChar = input.charAt(i);

            try{
                if (currentChar == '[' || currentChar == '{' || currentChar == '('){
                    s.push(currentChar);
                } else if (currentChar == ']'){
                    if (s.pop() != '['){
                        return false;
                    }
                } else if (currentChar == '}'){
                    if (s.pop() != '{'){
                        return false;
                    }
                } else if (currentChar == ')'){
                    if (s.pop() != '('){
                        return false;
                    }
                }

            } catch (StackEmptyException e){
                return false;
            }
        }
        return s.isEmpty();
    }


    public static void main(String[] args) {

        String exp = "{(2*3)+[4+(3*7)]}";
        String exp1 = "(2*3)+[4+(3*7)]}";
        String exp2 = "{(2*3)+[4+(3*7]}";
        String exp3 = "[{(2*3)+[4+(3*7)]}";
        String exp4 = "";

        System.out.println(exp + " Balanced: " + isBalanced(exp));
        System.out.println(exp1 + " Balanced: " + isBalanced(exp1));
        System.out.println(exp2 + " Balanced: " + isBalanced(exp2));
        System.out.println(exp3 + " Balanced: " + isBalanced(exp3));
        System.out.println(exp4 + " Balanced: " + isBalanced(exp4));

    }
}
