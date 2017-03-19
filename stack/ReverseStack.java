package stack;

public class ReverseStack {

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

        try {

            StackUsingArray s = new StackUsingArray();
            s.push(10);
            s.push(20);
            s.push(30);
            s.push(40);
            s.push(50);

            System.out.println("Original stack is");
            while (!s.isEmpty()){
                System.out.println(s.pop());
            }

            s.push(10);
            s.push(20);
            s.push(30);
            s.push(40);
            s.push(50);

            StackUsingArray rev = reverseStack(s);

            System.out.println("Reversed stack is");
            while (!rev.isEmpty()){
                System.out.println(rev.pop());
            }
        } catch (StackEmptyException e){
            System.out.println("Nothing in stack");
        }

    }

}
