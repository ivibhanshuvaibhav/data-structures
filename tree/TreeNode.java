package tree;

import java.util.ArrayList;

public class TreeNode<T> {

    private T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

}
