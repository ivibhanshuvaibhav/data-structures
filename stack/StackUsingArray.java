package stack;

public class StackUsingArray {

    private int[] data;
    private int nextIndex;

    public StackUsingArray(){
        data = new int[10];
        nextIndex = 0;
    }

    public int size(){
        return nextIndex;
    }

    public boolean isEmpty(){
        return (size() == 0);
    }

    public void push(int element){
        if(size() == data.length){
            int[] temp = data;
            data = new int[data.length * 2];
            for(int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }

        data[nextIndex] = element;
        nextIndex++;
    }

    public int top() throws StackEmptyException{

        if(size() == 0){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        return data[nextIndex--];

    }

    public int pop() throws StackEmptyException{

        if(size() == 0){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        nextIndex--;
        int toBeReturned = data[nextIndex];
        data[nextIndex] = 0;
        return toBeReturned;

    }

}
