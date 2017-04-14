package linked_list;

import static linked_list.LinkedListOperations.*;

public class SwapTwoNodes {

    public static void swapNodes(LinkedListNode<Integer> head, int element1, int element2){

        if (head == null){
            return;
        }
        if (element1 == element2){
            return;
        }

        LinkedListNode<Integer> currX = head, prevX = null;
        LinkedListNode<Integer> currY = head, prevY = null;

        while (currX != null){
            if (currX.getData() == element1){
                break;
            }
            prevX = currX;
            currX = currX.next;
        }

        while (currY != null){
            if (currY.getData() == element2){
                break;
            }
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null){
            return;
        }

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        LinkedListNode<Integer> temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static void main(String[] args) {

        LinkedListNode<Integer> head = linkedListInput();
        swapNodes(head, 2 ,6);
        printLinkedList(head);

    }
}
