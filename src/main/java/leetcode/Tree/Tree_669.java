package leetcode.Tree;

public class Tree_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        TrimRecusive(dummy, dummy.left, low, high, 1, 0);
        return dummy.left;
    }

    private void TrimRecusive(TreeNode parent, TreeNode cur, int low, int high, int left, int right){
        if(cur==null){
            if(left==1){
                parent.left = null;
            }else {
                parent.right= null;
            }
            return;
        }
        if(cur.value<low){
            TrimRecusive(parent, cur.right, low, high, left, right);
        }
        else if(cur.value>high){
            TrimRecusive(parent, cur.left, low, high, left, right);
        }else{
            if(left==1){
                parent.left = cur;
            }else {
                parent.right= cur;
            }
            TrimRecusive(cur, cur.left, low, high, 1, 0);
            TrimRecusive(cur, cur.right, low, high, 0, 1);
        }

    }
}
