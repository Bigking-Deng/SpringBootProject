package leetcode.Tree;

public class Tree_101 {

    public static boolean isSymmetric(TreeNode root) {
        return isValid(root.left, root.right);
    }

    public static boolean isValid(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        if(r1.value==r2.value && isValid(r1.left, r2.right) && isValid(r1.right, r2.left)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
