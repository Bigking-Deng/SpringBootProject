package leetcode.Tree;

public class Tree_99 {
   
        TreeNode firstNode1 = null;
        TreeNode firstNode2 = null;
        TreeNode secondNode1 = null;
        TreeNode secondNode2 = null;
        TreeNode preNode = new TreeNode(null, null, Integer.MIN_VALUE);
        

        public void recoverTree(TreeNode root) {

            in_order(root);
            if(secondNode1==null) swap(firstNode1, firstNode2);
            else swap(firstNode1, secondNode2);
        }
        private void swap(TreeNode firstNode, TreeNode secondNode){
            int tmp = firstNode.value;
            firstNode.value = secondNode.value;
            secondNode.value = tmp;
        }

        private void in_order(TreeNode root) {
            if (root == null) return;
            in_order(root.left);
            if (firstNode1 == null && preNode.value > root.value){
                firstNode1 = preNode;
                firstNode2 = root;
            }
            if (firstNode1 != null && preNode.value > root.value){
                secondNode1 = preNode;
                secondNode2 = root;
            }
            preNode = root;
            in_order(root.right);
        }
    
}
