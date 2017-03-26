package tree;

import sun.misc.Queue;

import java.util.Scanner;

public class TreeOperations {

    // take input of a tree level wise

    public static TreeNode<Integer> treeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root");
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()){
            try {
                TreeNode<Integer> data = queue.dequeue();
                System.out.println("Enter number of children for " + data.getData());
                int children = s.nextInt();
                for (int i = 1; i <= children; i++){
                    System.out.println("Enter data for " + i + "th children of " + data.getData());
                    int nextElement = s.nextInt();
                    TreeNode<Integer> child = new TreeNode<>(nextElement);
                    queue.enqueue(child);
                    data.children.add(child);
                }
            } catch (InterruptedException e){
                System.out.println("Queue is empty");
            }

        }

        return root;
    }

    // take input of a tree

    public static TreeNode<Integer> treeInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root");
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);

        System.out.println("Enter number of children for " + rootData);
        int children = s.nextInt();

        for (int i = 0; i < children; i++){
            root.children.add(treeInput());
        }

        return root;
    }

    // print a tree

    public static void printTree(TreeNode<Integer> treeNode){

        String toBeReturned = treeNode.getData() + ":";

        for(int i = 0; i < treeNode.children.size(); i++){
            toBeReturned = toBeReturned + treeNode.children.get(i).getData() + ",";
        }

        System.out.println(toBeReturned);

        for(int i = 0; i<treeNode.children.size(); i++){
            printTree(treeNode.children.get(i));
        }

    }

    // find maximum element of tree

    public static int max(TreeNode<Integer> root){
        int max = root.getData();

        for (int i = 0; i < root.children.size(); i++){
            int childMax = max(root.children.get(i));
            if (childMax > max){
                max = childMax;
            }
        }

        return max;
    }

    // pre-order traversal of tree

    public static void preOrder(TreeNode<Integer> root){

        System.out.println(root.getData());

        for (TreeNode<Integer> child: root.children){
            preOrder(child);
        }
    }

    // post-order traversal of tree

    public static void postOrder(TreeNode<Integer> root){

        for (TreeNode<Integer> child: root.children){
            postOrder(child);
        }

        System.out.println(root.getData());
    }

    // find number of nodes in a tree

    public static int count(TreeNode<Integer> root){
        int count = 1;

        for (int i = 0; i < root.children.size(); i++){
            count = count + count(root.children.get(i));
        }

        return count;
    }

    public static void main(String[] args) {

        // 2 2 5 6 2 78 89 2 3 56 0 0 0 0

        TreeNode<Integer> root = treeInputLevelWise();
        printTree(root);

        System.out.println("Maximum is " + max(root));
        System.out.println("Size is " + count(root));
        System.out.println("Preorder is ");
        preOrder(root);
        System.out.println("Postorder is ");
        postOrder(root);

    }

}
