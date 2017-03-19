package queue;

import stack.StackEmptyException;
import stack.StackUsingArray;

public class ReverseQueue {

    // reverse a queue

    public static StackUsingArray reverseQueue(QueueUsingArray q){

        StackUsingArray s = new StackUsingArray();

        while (!q.isEmpty()){
            try {
                s.push(q.dequeue());
            } catch (QueueEmptyException e){
                System.out.println("Queue is empty");
            }
        }

        return s;

    }

    public static void main(String[] args) {

        try {

            QueueUsingArray q = new QueueUsingArray();

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);

            System.out.println("Original queue is");
            while (!q.isEmpty()){
               System.out.println(q.dequeue());
            }

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);

            StackUsingArray rev = reverseQueue(q);

            System.out.println("Reversed queue is");
            while (!rev.isEmpty()){
                System.out.println(rev.pop());
            }
        } catch (StackEmptyException| QueueEmptyException e){
            System.out.println("Nothing in queue");
        }

    }

}
