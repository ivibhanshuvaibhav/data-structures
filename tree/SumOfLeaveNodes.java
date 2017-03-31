package tree;

import static tree.BinaryTreeOperations.*;

public class SumOfLeaveNodes {

    public static int sumOfLeaves(BinaryTreeNode<Integer> root){

        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        return sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }

    public static void main(String[] args) {

        // 1 2 4 -1 -1 -1 3 -1 5 -1 -1

        BinaryTreeNode<Integer> root = takeInputBT();
        System.out.println("Tree is");
        printBT(root);
        System.out.println("Sum of leave nodes is " + sumOfLeaves(root));

    }

}
