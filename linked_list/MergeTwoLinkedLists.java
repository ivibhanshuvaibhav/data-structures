package linked_list;

import static linked_list.LinkedListOperations.*;

public class MergeTwoLinkedLists {

    // merge 2 sorted linked lists

    public static LinkedListNode<Integer> mergeLinkedList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){

        if(head1 == null && head2 != null){
            return head2;
        }else if(head1 != null && head2 == null){
            return head1;
        }else if(head1 == null && head2 == null){
            return null;
        }

        LinkedListNode<Integer> newList = null;

        if(head1.getData() <=  head2.getData()){
            newList = head1;
            newList.next = mergeLinkedList(head1.next, head2);
        }else if(head1.getData() >  head2.getData()){
            newList = head2;
            newList.next = mergeLinkedList(head1, head2.next);
        }

        return newList;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head1 = linkedListInput();
        LinkedListNode<Integer> head2 = linkedListInput();

        System.out.println("First Linked List is:");
        printLinkedList(head1);

        System.out.println("\nSecond Linked List is:");
        printLinkedList(head2);

        System.out.println("\nMerged Linked List is:");

        printLinkedList(mergeLinkedList(head1, head2));

    }

}
