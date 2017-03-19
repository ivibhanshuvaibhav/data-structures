package linked_list;

import java.util.Scanner;

public class LinkedListUse {

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

        System.out.println("\n\nLinked List is");
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


    // arrange elements in a Linked List such that all even numbers are placed after odd numbers

    public static LinkedListNode<Integer> arrangeLinkedList(LinkedListNode<Integer> head){

        if(head == null){
            return head;
        }

        LinkedListNode<Integer> evenList = null;
        LinkedListNode<Integer> oddList = null;

        if(head.getData()%2 == 0){
            oddList = head;
            oddList.next = arrangeLinkedList(head.next);
        }else {
            oddList = head;
            oddList.next = arrangeLinkedList(head.next);
        }
//
//        printLinkedList(evenList);
////        printLinkedList(oddList);


        return oddList;
    }

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
            printLinkedList(head);
            return checkPalindrome(head);
        }

        return false;

    }

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

        // 1 2 3 4 5 6 7 8 9 10 -1
        // 2 4 6 8 10 12 14 16 18 20 -1

//        LinkedListNode head = linkedListInput();
        LinkedListNode<Integer> head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head.next.next.next.next.next.next = new LinkedListNode(7);
        head.next.next.next.next.next.next.next = new LinkedListNode(8);
        head.next.next.next.next.next.next.next.next = new LinkedListNode(9);
        head.next.next.next.next.next.next.next.next.next = new LinkedListNode(10);
//        LinkedListNode<Integer> head = new LinkedListNode(1);
//        head.next = new LinkedListNode(2);
//        head.next.next = new LinkedListNode(3);
//        head.next.next.next = new LinkedListNode(4);
//        head.next.next.next.next = new LinkedListNode(5);
//        head.next.next.next.next.next = new LinkedListNode(5);
//        head.next.next.next.next.next.next = new LinkedListNode(4);
//        head.next.next.next.next.next.next.next = new LinkedListNode(3);
//        head.next.next.next.next.next.next.next.next = new LinkedListNode(2);
//        head.next.next.next.next.next.next.next.next.next = new LinkedListNode(1);
        printLinkedList(head);
//        LinkedListNode head1 = head;
//        LinkedListNode head2 = linkedListInput();

//        System.out.println("Length of Linked List is " + linkedListLength(head));
//        System.out.println("Length of Linked List is " + linkedListLengthRecursion(head));
//
//        System.out.println("Linked List in reverse order is");
//        printReverseLinkedList(head);
//
//        System.out.println("Middle element of the linked list is");
//        middleLinkedList(head);
////
//        head = insertIteratively(head, 10, 20);
//
//        printLinkedList(head);
//
//        head = deleteIteratively(head, 10);
////
//        printLinkedList(head);
//
////        printLinkedList(insertIteratively(head, 0, 10));
////        printLinkedList(deleteIteratively(head, 0));
////
////        printLinkedList(appendToFront(head, 4));
////
////        printLinkedList(mergeLinkedList(head, head2));
////
////        printLinkedList(arrangeLinkedList(head));
//
//        insertRecursively(head, 10, 20);
//
//        printLinkedList(head);
//
//        head = deleteRecursively(head, 10);
////
//        printLinkedList(head);
//
//        boolean result = checkPalindrome(head);
//
//        if(result == true){
//            System.out.println("\n\nLinked List is palindrome");
//        }else{
//            System.out.println("\n\nLinked List is not palindrome");
//        }

    }

}