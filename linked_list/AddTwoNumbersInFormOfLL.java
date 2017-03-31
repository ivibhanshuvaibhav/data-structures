package linked_list;

import static linked_list.LinkedListOperations.*;

public class AddTwoNumbersInFormOfLL {

    public static LinkedListNode<Integer> makeNumber(int result, int length){

        if(length == 0){
            return null;
        }

        LinkedListNode<Integer> head;
        int temp = result / (int) Math.pow(10, length - 1);
        temp = temp % 10;
        head = new LinkedListNode<>(temp);
        head.next = makeNumber(result, length - 1);

        return head;

    }

    public static LinkedListNode<Integer> addLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){

        if (head1 == null || head2 == null){
            return null;
        }

        int num1 = 0;
        int num2 = 0;

        int length1 = linkedListLength(head1);
        int length2 = linkedListLength(head2);

        while (head1 != null){
            num1 = num1 + head1.getData() * (int) Math.pow(10, length1 - 1);
            length1--;
            head1 = head1.next;
        }

        while (head2 != null){
            num2 = num2 + head2.getData() * (int) Math.pow(10, length2 - 1);
            length2--;
            head2 = head2.next;
        }

        int result = num1 + num2;

        int length = Integer.toString(result).length();

        return makeNumber(result, length);

    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head1 = linkedListInput();
        LinkedListNode<Integer> head2 = linkedListInput();

        System.out.println("New linked list is ");
        printLinkedList(addLinkedLists(head1, head2));

    }

}
