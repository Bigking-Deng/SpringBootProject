package leetcode;

public class Tree_114 {

    private static TreeNode prevNode;

    private static void preOrderRight(TreeNode root){
        if(root==null) return;
        if(prevNode!=null){
            prevNode.right = root;
        }
        prevNode = root;
        preOrderRight(root.right);
        preOrderRight(root.left);
        root.left=null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
         prevNode = null;
         preOrderRight(root);
    }
}


