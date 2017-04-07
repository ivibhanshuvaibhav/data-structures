package linked_list;

import static linked_list.LinkedListOperations.*;

public class ReverseLL {

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head){

        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> prev = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("\nOriginal Linked List");
        printLinkedList(head);

        System.out.println("\nReversed Linked List");
        printLinkedList(reverseLinkedList(head));

    }
}
