package leetcode.Tree;

public class Tree_437 {
    public int pathSum(TreeNode root, int targetSum) {

        if(root==null) return 0;
        return getSumNumber(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    private int getSumNumber(TreeNode root, int targetSum){
        if(root==null) return 0;
        int num=0;
        if(root.value==targetSum){
            num++;
        }
        return num + getSumNumber(root.left, targetSum-root.value) + getSumNumber(root.right, targetSum-root.value);
    }
}
