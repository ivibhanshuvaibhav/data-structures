package stack;

import linked_list.LinkedListNode;

public class StackUsingLinkedList {

    private LinkedListNode<Integer> head;
    private int length = 0;

    public StackUsingLinkedList(){
        head = null;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void push(int element){

        LinkedListNode<Integer> newNode = new LinkedListNode<>(element);

        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

        length++;

    }

    public int top(){

        if(size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }

        return head.getData();
    }

    public int pop(){

        if(size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }

        int toBeReturned = head.getData();
        head = head.next;
        length--;

        return toBeReturned;

    }

}
