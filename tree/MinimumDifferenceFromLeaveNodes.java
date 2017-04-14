package tree;

import static tree.BinaryTreeOperations.*;

public class MinimumDifferenceFromLeaveNodes {

    public static int calculateMinimumDifferenceFromLeaveNodes(BinaryTreeNode<Integer> root, int num){

        if(root == null){
            return num;
        }

        if ((root.left == null) && ( root.right == null)){
            int diff = Integer.MAX_VALUE;
            int temp;

            temp = num - root.data;
            if(temp < diff){
                diff = temp;
            }
            return diff;
        }

        return Math.min(calculateMinimumDifferenceFromLeaveNodes(root.left, num),
            calculateMinimumDifferenceFromLeaveNodes(root.right, num));

    }

    public static void main(String[] args) {

        // 1 2 4 -1 -1 -1 3 -1 5 -1 -1

        int number = 10;

        BinaryTreeNode<Integer> root = takeInputBT();
        System.out.println("Tree is");
        printBT(root);
        System.out.println("Minimum difference from leave nodes is " + calculateMinimumDifferenceFromLeaveNodes(root, number));

    }

}
