package linked_list;

import static linked_list.LinkedListOperations.*;

public class ArrangeEvenNodesFirst {

    // arrange elements in a Linked List such that all even numbers are placed after odd numbers

    public static LinkedListNode<Integer> arrangeLinkedList(LinkedListNode<Integer> head){

        if (head == null){
            return head;
        }

        LinkedListNode<Integer> evenHead = null;
        LinkedListNode<Integer> evenTail = null;

        LinkedListNode<Integer> oddHead = null;
        LinkedListNode<Integer> oddTail = null;

        while (head != null){
            int data = head.getData();
            LinkedListNode<Integer> temp = new LinkedListNode<>(data);
            if (data % 2 == 0){
                if (evenHead == null){
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            } else if (data % 2 == 1){
                if (oddHead == null){
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }

            head = head.next;
        }

        evenTail.next = oddHead;

        return evenHead;
    }

    public static LinkedListNode<Integer> arrangeLinkedList1(LinkedListNode<Integer> head){
        if (head == null){
            return head;
        }

        LinkedListNode<Integer> evenList = null;
        LinkedListNode<Integer> oddList = null;

        if (head.getData() % 2 == 1){
            oddList = head;
            oddList.next = arrangeLinkedList1(head.next);
            return oddList;
        }

        if (head.getData() % 2 == 0){
            evenList = head;
            evenList.next = arrangeLinkedList1(head.next);
            return evenList;
        }

        oddList.next = evenList;
        return oddList;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        printLinkedList(arrangeLinkedList(head));
    }

}
