package leetcode.Tree;

public class Tree_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return detectResult(root, targetSum, 0);

    }

    private boolean detectResult(TreeNode root, int targetSum, int total){
        if(root.left==null && root.right==null){
            if(total+ root.value==targetSum) return true;
            else return false;
        }
        if(root.left!=null && root.right!=null) return detectResult(root.left, targetSum, total+root.value)||detectResult(root.right, targetSum,total+root.value);
        if(root.left!=null) return detectResult(root.left, targetSum, total+root.value);
        else return detectResult(root.right, targetSum, total+root.value);
    }





        public boolean hasPathSum2(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.value;
            }
            return hasPathSum2(root.left, sum - root.value) || hasPathSum2(root.right, sum - root.value);
        }



}
