package leetcode.Tree;

public class Tree_124 {
    class Solution {
        public int maxPathSum(TreeNode root) {
            if(root==null) return 0;
            int max = 0;
            int leftSubTreeMax = Math.max(getMaxPathFromRoot(root.left), 0);
            int rightSubTreeMax = Math.max(getMaxPathFromRoot(root.right), 0);
//            if(leftSubTreeMax > rightSubTreeMax){
//                if(rightSubTreeMax>0){
//                    max = leftSubTreeMax+rightSubTreeMax+root.value;
//                }else{
//                    max = leftSubTreeMax+root.value;
//                }
//            }
//            else {
//                if (leftSubTreeMax > 0) {
//                    max = leftSubTreeMax + rightSubTreeMax + root.value;
//                } else {
//                    max = rightSubTreeMax + root.value;
//                }
//            }
            max = leftSubTreeMax + rightSubTreeMax + root.value;
            if(root.left!=null){
                max = Math.max(maxPathSum(root.left), max);
            }
            if(root.right!=null){
                max = Math.max(maxPathSum(root.right), max);
            }
            return Math.max(max, root.value);
        }

        private int getMaxPathFromRoot(TreeNode root){
            if(root==null) return 0;
            int leftmax = getMaxPathFromRoot(root.left);
            int rightmax = getMaxPathFromRoot(root.right);
            return Math.max(0, Math.max(leftmax, rightmax))+root.value;
        }
    }
}
