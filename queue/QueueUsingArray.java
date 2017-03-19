package queue;

public class QueueUsingArray {

    private int[] data;
    private int firstIndex;
    private int nextIndex;
    private int size;

    public QueueUsingArray(){
        data = new int[10];
        firstIndex = -1;
        nextIndex = 0;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void enqueue(int element){
        if (size() == data.length){
            int[] temp = data;
            data = new int[data.length * 2];
            for (int i = firstIndex; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        if(size == 0){
            firstIndex = 0;
        }

        data[nextIndex] = element;
        nextIndex++;
        size++;

    }

    public int front() throws QueueEmptyException{
        if (size() == 0){
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }

        return data[firstIndex];

    }

    public int dequeue() throws QueueEmptyException{
        if (size() == 0){
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }

        int toBeReturned = data[firstIndex];
        data[firstIndex] = 0;
        firstIndex++;
        size--;
        if(size == 0){
            firstIndex = -1;
            nextIndex = 0;
            size = 0;
        }

        return toBeReturned;

    }

}
