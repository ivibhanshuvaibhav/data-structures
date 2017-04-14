package stack;

public class MaximumElement {

    public static int putElement(StackUsingLinkedList stack, StackUsingLinkedList max, int element){

        stack.push(element);

        if (stack.size() == 1){
            max.push(element);
        }
        else {
            if (element > max.top()){
                max.push(element);
            }
        }

        return max.top();
    }

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        StackUsingLinkedList max = new StackUsingLinkedList();

        System.out.println(putElement(stack, max, 1));
        System.out.println(putElement(stack, max, 10));
        System.out.println(putElement(stack, max, 5));
        System.out.println(putElement(stack, max, 15));
        System.out.println(putElement(stack, max, 20));
        System.out.println(putElement(stack, max, 2));
        System.out.println(putElement(stack, max, 40));
        System.out.println(putElement(stack, max, 100));
        System.out.println(stack.size());
        System.out.println(max.size());

    }

}

