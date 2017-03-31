package tree;

import java.util.Scanner;

public class BinaryTreeOperations {

    // take input for binary tree

    public static BinaryTreeNode<Integer> takeInputBT(){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter root");
        int rootData = s.nextInt();
        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        System.out.println("Enter left children of " + root.data);
        root.left = takeInputBT();
        System.out.println("Enter right children of " + root.data);
        root.right = takeInputBT();

        return root;
    }

    // print binary tree

    public static void printBT(BinaryTreeNode<Integer> root){

        if (root == null){
            return;
        }

        String toBePrinted = root.data + ":";

        if (root.left != null){
            toBePrinted = toBePrinted + root.left.data;
        }
        if (root.right != null){
            toBePrinted = toBePrinted + "," + root.right.data;
        }

        System.out.println(toBePrinted);

        printBT(root.left);
        printBT(root.right);

    }

    // count the number of nodes in the tree

    public static int count(BinaryTreeNode<Integer> root){

        if (root == null){
            return 0;
        }

        int count = 1;

        count = count + count(root.left) + count(root.right);

        return count;

    }

    // height of the binary tree

    public static int height(BinaryTreeNode<Integer> root){

        if (root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left) , height(root.right));

    }

    // sum of all the nodes of a binary tree

    public static int sum(BinaryTreeNode<Integer> root){

        if(root == null){
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);

    }

    // diameter of the binary tree

    public static int diameter(BinaryTreeNode<Integer> root){

        if (root == null){
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int choice1 = lHeight + rHeight;
        int choice2 = diameter(root.left);
        int choice3 = diameter(root.right);

        return Math.max(Math.max(choice1, choice2), choice3);

    }

    // check if the given tree is balanced or not

    public static boolean isBalancedTree(BinaryTreeNode<Integer> root){

        if (root == null){
            return true;
        }

        if (height(root.left) == height(root.right)){
            isBalancedTree(root.left);
            isBalancedTree(root.right);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        // 1 2 4 -1 -1 -1 3 -1 5 -1 -1

        BinaryTreeNode<Integer> root = takeInputBT();

        printBT(root);

        System.out.println("Total numbers of nodes are: " + count(root));

        System.out.println("Total height of tree is: " + height(root));

        System.out.println("Sum of nodes of the tree is: " + sum(root));

        System.out.println("Diameter of the tree is: " + diameter(root));

        System.out.println("Is the tree balanced? " + isBalancedTree(root));

    }
}