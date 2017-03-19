package queue;

import linked_list.LinkedListNode;

public class QueueUsingLinkedList {

    private LinkedListNode<Integer> head;
    private LinkedListNode<Integer> tail;
    private int length;

    public QueueUsingLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void enqueue(int element){

        LinkedListNode<Integer> newNode = new LinkedListNode<>(element);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

        length++;

    }

    public int front(){

        if (size() == 0){
            System.out.println("Queue is empty");
            return -1;
        }

        return head.getData();

    }

    public int dequeue(){

        if (size() == 0){
            System.out.println("Queue is empty");
            return -1;
        }

        int toBeReturned = head.getData();
        head = head.next;
        length--;

        return toBeReturned;

    }


}
