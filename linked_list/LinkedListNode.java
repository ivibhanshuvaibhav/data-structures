package linked_list;

public class LinkedListNode<T> {

    private T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data){
        this.data = data;
        this.next = null;
    }

    public T getData(){
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}