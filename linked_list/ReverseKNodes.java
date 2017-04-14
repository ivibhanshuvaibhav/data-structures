package linked_list;

import static linked_list.LinkedListOperations.*;

public class ReverseKNodes {

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int num){

        if (head == null){
            return head;
        }

        if (num == 0 || num == 1){
            return head;
        }

        int pos = 0;

        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> prev = null;

        while (curr != null && pos < num){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            pos++;
        }

        head.next = kReverse(curr, num);

        return prev;

    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();
        printLinkedList(kReverse(head, 3));

    }

}
