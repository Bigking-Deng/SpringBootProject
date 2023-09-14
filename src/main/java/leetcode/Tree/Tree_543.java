package leetcode.Tree;

public class Tree_543 {
    static int maxValue = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxSideLength(root);
        return maxValue-1;//maxValue is the node number, minus 1 is the diameter.
    }

    public int maxSideLength(TreeNode root){
        if(root==null) return 0;
        int llen = maxSideLength(root.left);
        int rlen = maxSideLength(root.right);
        maxValue = Math.max(maxValue, llen+rlen+1);
        return 1+Math.max(llen, rlen);
    }

    public static void main(String[] args) {

    }
}
