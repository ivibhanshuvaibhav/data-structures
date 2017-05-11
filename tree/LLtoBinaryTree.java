package tree;

import linked_list.LinkedListNode;
import static linked_list.LinkedListOperations.*;
import static tree.BinaryTreeOperations.*;

public class LLtoBinaryTree {

    public static BinaryTreeNode<Integer> LLtoBT(LinkedListNode<Integer> head, int start, int end){

        if (head == null){
            return null;
        }

        if (start > end){
            return null;
        }

        int mid = (start + end) / 2;
        int i = 0;

        LinkedListNode<Integer> middle = head;

        while (middle != null && i != mid){
            middle = middle.next;
            i++;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(middle.getData());
        root.left = LLtoBT(head, start, mid - 1);
        root.right = LLtoBT(head, mid + 1, end);

        return root;

    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();

        System.out.println("\nLinked list is:\n");
        printLinkedList(head);

        int length = linkedListLength(head);

        System.out.println("\nTree is\n");
        printBT(LLtoBT(head, 0, length - 1));

    }

}
