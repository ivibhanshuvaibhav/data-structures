package linked_list;

import static linked_list.LinkedListOperations.*;

public class EliminateDuplicateNodes {

    // Eliminate duplicates from a sorted linked list

    public static LinkedListNode<Integer> eliminateDuplicates(LinkedListNode<Integer> head){

        if(head == null){
            return head;
        }

        if(head.next != null && head.getData() == head.next.getData()){
            eliminateDuplicates(head.next);
            head.next = head.next.next;
        }

        eliminateDuplicates(head.next);

        return head;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("Original Linked List is:");

        printLinkedList(head);

        System.out.println("\nLinked List with duplicate nodes removed is:");

        printLinkedList(eliminateDuplicates(head));

    }

}
