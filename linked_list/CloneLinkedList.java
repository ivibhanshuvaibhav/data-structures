package linked_list;

import static linked_list.LinkedListOperations.*;

public class CloneLinkedList {

    // Clone a linked list

    public static LinkedListNode<Integer> cloneLL(LinkedListNode<Integer> head){

        if (head == null){
            return null;
        }

        LinkedListNode<Integer> newList;

        int temp = head.getData();
        newList = new LinkedListNode<>(temp);
        newList.next = cloneLL(head.next);

        return newList;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("Original Linked List is:");

        printLinkedList(head);

        System.out.println("\nCloned Linked List is:");

        printLinkedList(cloneLL(head));

    }

}
