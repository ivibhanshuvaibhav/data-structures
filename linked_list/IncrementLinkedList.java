package linked_list;

import static linked_list.LinkedListOperations.*;

public class IncrementLinkedList {

    public static LinkedListNode<Integer> numberToLinkedList(int number, int length){

        if(length == 0){
            return null;
        }

        LinkedListNode<Integer> head;
        int temp = number / (int) Math.pow(10,length-1);

        temp = temp % 10;

        head = new LinkedListNode<>(temp);

        head.next = numberToLinkedList(number, length - 1);

        return head;

    }

    public static LinkedListNode<Integer> incrementLinkedList(LinkedListNode<Integer> head){

        int length = linkedListLength(head);

        int number = 0;

        while (head != null){
            number = number + head.getData() * (int) Math.pow(10,length-1);
            length--;
            head = head.next;
        }

        number = number + 1;

        System.out.println("Number is " + number);

        length = Integer.toString(number).length();

        return numberToLinkedList(number,length);
    }

    public static void main(String[] args) {

        // 1 2 3 4 -1

        printLinkedList(incrementLinkedList(linkedListInput()));

    }
}
