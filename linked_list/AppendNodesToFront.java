package linked_list;

import static linked_list.LinkedListOperations.*;

public class AppendNodesToFront {

    // append last n elements to front

    public static LinkedListNode<Integer> appendToFront(LinkedListNode<Integer> head, int n){

        if(head == null){
            return null;
        }

        if(n >= linkedListLength(head)){
            return head;
        }

        int pos = linkedListLength(head) - n;
        int i = 1;

        LinkedListNode<Integer> tempHead = head;

        while(i+1 <= pos){
            tempHead = tempHead.next;
            i++;
        }

        LinkedListNode<Integer> newHead = tempHead.next;
        tempHead.next = null;

        tempHead = newHead;

        while(tempHead.next!=null){
            tempHead = tempHead.next;
        }

        tempHead.next = head;

        return newHead;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("Original Linked List is:");

        printLinkedList(head);

        System.out.println("\nNew Linked List is:");

        printLinkedList(appendToFront(head, 4));

    }

}
