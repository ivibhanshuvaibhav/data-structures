package queue;

import stack.StackEmptyException;
import stack.StackUsingArray;
import stack.StackUsingLinkedList;

import java.util.Stack;

public class QueueUsingStacks {

    StackUsingLinkedList s1 = new StackUsingLinkedList();
    StackUsingLinkedList s2 = new StackUsingLinkedList();
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void enqueue(int element){
        if (size() == 0){
            s1.push(element);
        } else{

            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(element);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }

        }
        size++;
    }

    public int front(){

        if (size() == 0){
            System.out.println("Stack is empty");
        }
        int toBeReturned = s1.pop();
        s1.push(toBeReturned);
        return toBeReturned;

    }

    public int dequeue(){

        if (size() == 0){
            System.out.println("Stack is empty");
        }
        int toBeReturned = s1.pop();
        size--;
        return toBeReturned;

    }

    public static void main(String[] args) {

        QueueUsingStacks q = new QueueUsingStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println(q.front());

        while (!q.isEmpty()){
            System.out.println(q.dequeue());
        }

    }

}
