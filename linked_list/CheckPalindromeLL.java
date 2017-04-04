package linked_list;

import static linked_list.LinkedListOperations.*;

public class CheckPalindromeLL {

    public static int elementAtPosition(LinkedListNode<Integer> head, int position){

        int i = 1;
        while(i < position){
            head = head.next;
            i++;
        }

        return head.getData();

    }

    public static LinkedListNode<Integer> removeAtBeginningAndEnd(LinkedListNode<Integer> head){

        head = deleteIteratively(head, 0);
        head = deleteIteratively(head, linkedListLength(head)-1);

        return head;

    }

    public static boolean checkPalindrome(LinkedListNode<Integer> head){

        if(head == null){
            return true;
        }

        if(linkedListLength(head) == 1){
            return true;
        }

        if(elementAtPosition(head,0) == elementAtPosition(head, linkedListLength(head))){
            head = removeAtBeginningAndEnd(head);
            return checkPalindrome(head);
        }

        return false;

    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("Original Linked List is:");

        printLinkedList(head);

        System.out.println("\nIs the linked list a palindrome?");

        System.out.println(checkPalindrome(head)?"YES":"NO");
    }

}
