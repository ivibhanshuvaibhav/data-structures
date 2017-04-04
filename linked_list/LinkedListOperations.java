package linked_list;

import java.util.Scanner;

public class LinkedListOperations {

    // taking input as linked list

    public static LinkedListNode<Integer> linkedListInput(){

        Scanner s = new Scanner(System.in);
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        System.out.println("Enter first element");
        int nextElement = s.nextInt();
        while(nextElement!=-1){
            LinkedListNode<Integer> nextNode = new LinkedListNode<>(nextElement);
            if(head == null){
                head = nextNode;
                tail = nextNode;
            }
            else{
                tail.next = nextNode;
                tail = nextNode;
            }
            System.out.println("Enter next element");
            nextElement = s.nextInt();
        }
        return head;
    }

    // printing the linked list taken as input

    public static void printLinkedList(LinkedListNode<Integer> head){

        while (head != null){
            System.out.print(head.getData()+"-->");
            head = head.next;
        }

    }

    // linked list length using iteration

    public static int linkedListLength(LinkedListNode<Integer> head){

        int length = 0;

        while (head != null){
            length++;
            head = head.next;
        }

        return length;
    }

    // linked link length using recursion

    public static int linkedListLengthRecursion(LinkedListNode<Integer> head){

        if(head == null){
            return 0;
        }

        return 1 + linkedListLengthRecursion(head.next);
    }

    // printing reverse of linked list

    public static void printReverseLinkedList(LinkedListNode<Integer> head){

        if(head != null){
            printReverseLinkedList(head.next);
            System.out.print(head.getData() + "-->");
        }

    }

    // printing the middle element of linked list

    public static void middleLinkedList(LinkedListNode<Integer> head){

        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.getData());
    }

    // inserting a node iteratively

    public static LinkedListNode<Integer> insertIteratively(LinkedListNode<Integer> head, int position, int data){

        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

        if(position == 0){
            newNode.next = head;
            return newNode;
        }

        if(head == null){
            return head;
        }

        if(position > linkedListLength(head)){
            return head;
        }

        LinkedListNode<Integer> newHead = head;

        int i = 1;

        while(i < position){
            newHead = newHead.next;
            i++;
        }

        newNode.next = newHead.next;
        newHead.next = newNode;

        return head;
    }

    // inserting a node recursively

    public static LinkedListNode<Integer> insertRecursively(LinkedListNode<Integer> head, int position, int data){

        if(position == 0){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            newNode.next = head;
            return newNode;
        }

        if(head == null){
            return head;
        }

        if(position > linkedListLength(head)){
            return head;
        }

        head.next = insertRecursively(head.next, position-1, data);

        return head;
    }

    // deleting a node iteratively

    public static LinkedListNode<Integer> deleteIteratively(LinkedListNode<Integer> head, int position){

        if(head == null){
            return head;
        }

        if(position > linkedListLength(head)){
            return head;
        }

        if(position == 0){
            head = head.next;
            return head;
        }

        LinkedListNode<Integer> newHead = head;
        int i = 1;

        while(i < position){
            newHead = newHead.next;
            i++;
        }

        newHead.next = newHead.next.next;

        return head;
    }

    // deleting a node recursively

    public static LinkedListNode<Integer> deleteRecursively(LinkedListNode<Integer> head, int position){

        if(head == null){
            return head;
        }

        if(position > linkedListLength(head)){
            return head;
        }

        if(position == 0){
            head = head.next;
            return head;
        }

        head.next = deleteRecursively(head.next, position-1);

        return head;
    }


    public static void main(String[] args) {

        // 1 2 3 4 5 6 7 8 9 10 -1
        // 2 4 6 8 10 12 14 16 18 20 -1

        LinkedListNode head = linkedListInput();

        System.out.println("\nLinked list is");
        printLinkedList(head);

        //length of linked list

        System.out.println("\nLength of Linked List is(iteratively): " + linkedListLength(head));
        System.out.println("\nLength of Linked List is(recursively): " + linkedListLengthRecursion(head));

        //printing reverse of linked list

        System.out.println("\nLinked List in reverse order is");
        printReverseLinkedList(head);

        //middle element of linked list

        System.out.println("\nMiddle element of the linked list is");
        middleLinkedList(head);

        //insert in linked list iteratively

        System.out.println("\n\nInserting iteratively");
        head = insertIteratively(head, 10, 20);
        printLinkedList(head);

        //delete in linked list iteratively

        System.out.println("\n\nDeleting iteratively");
        head = deleteIteratively(head, 10);
        printLinkedList(head);

        //insert in linked list recursively

        System.out.println("\n\nInserting recursively");
        insertRecursively(head, 10, 20);
        printLinkedList(head);

        //delete in linked list recursively

        System.out.println("\n\nDeleting recursively");
        head = deleteRecursively(head, 10);
        printLinkedList(head);

    }

}