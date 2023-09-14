package leetcode.Tree;

public class Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode par){
        if(par==null) return;
        TreeNode swap;
        swap = par.left;
        par.left=par.right;
        par.right=swap;
        invert(par.left);
        invert(par.right);
    }

    public static void main(String[] args) {

    }
}
