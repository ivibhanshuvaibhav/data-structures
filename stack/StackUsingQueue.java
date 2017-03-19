package stack;

import queue.QueueUsingLinkedList;

public class StackUsingQueue {

    QueueUsingLinkedList q1 = new QueueUsingLinkedList();
    QueueUsingLinkedList q2 = new QueueUsingLinkedList();
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void push(int element){

        if(size() == 0){
            q1.enqueue(element);
        } else {

            while (!q1.isEmpty()) {
                q2.enqueue(q1.dequeue());
            }
            q1.enqueue(element);
            while (!q2.isEmpty()) {
                q1.enqueue(q2.dequeue());
            }

        }
        size++;
    }

    public int top(){

        if (size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        int toBeReturned = q1.dequeue();
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        q1.enqueue(toBeReturned);
        while (!q2.isEmpty()) {
            q1.enqueue(q2.dequeue());
        }
        return toBeReturned;

    }

    public int pop(){

        if (size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        int toBeReturned = q1.dequeue();
        size--;
        return toBeReturned;

    }

    public static void main(String[] args) {

       StackUsingQueue s = new StackUsingQueue();

       System.out.println(s.size());
       System.out.println(s.top());
       s.push(10);
       s.push(20);
       s.push(30);
       s.push(40);
       System.out.println(s.top());
       while (!s.isEmpty())
           System.out.println(s.pop());
       System.out.println(s.size());

    }

}
