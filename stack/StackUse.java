package stack;

public class StackUse {

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

    // reverse a stack using another empty stack

    public static StackUsingArray reverseStack(StackUsingArray s){

        StackUsingArray r = new StackUsingArray();

        while (!s.isEmpty()){
            try {
                r.push(s.pop());
            } catch (StackEmptyException e){
                System.out.println("Stack is empty");
            }
        }

        return r;
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

        StackUsingArray s = new StackUsingArray();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

//        StackUsingArray b = s;
//
//        System.out.println("Original stack is");
//
//        while (!b.isEmpty()){
//            try {
//                System.out.println(b.pop());
//            } catch (StackEmptyException e){
//                System.out.println("Nothin in stack");
//            }
//        }

        System.out.println("Reversed stack is");

        StackUsingArray rev = reverseStack(s);

        while (!rev.isEmpty()){
            try {
                System.out.println(rev.pop());
            } catch(StackEmptyException e){
                System.out.println("Nothing in stack");
            }
        }


    }
}
