package leetcode.Tree;

public class Tree_114 {

    private static TreeNode prevNode;

    private static void preOrderRight(TreeNode root){
        if(root==null) return;

        preOrderRight(root.right);
        preOrderRight(root.left);
        root.right = prevNode;
        root.left=null;
        prevNode = root;


    }

    private static void preOrderRight2(TreeNode root){

        if(prevNode!=null){
            prevNode.left =  prevNode.right;
            prevNode.right = root;
        }
        if(root==null) return;
        prevNode = root;
        preOrderRight2(root.left);
        preOrderRight2(root.left);
        root.left=null;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode();
         prevNode = null;
         preOrderRight(root);
    }
}


