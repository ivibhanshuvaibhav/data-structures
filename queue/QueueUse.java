package queue;

import stack.StackEmptyException;
import stack.StackUsingArray;

public class QueueUse {

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

        QueueUsingArray q = new QueueUsingArray();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        StackUsingArray rev = reverseQueue(q);

        while (!rev.isEmpty()){
            try {
                System.out.println(rev.pop());
            } catch (StackEmptyException e){
                System.out.println("Queue is empty");
            }
        }

    }

}
