package leetcode.Tree;

public class Tree_450 {
    static TreeNode parent = null;
    static TreeNode target = null;
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

       findTargetAndParent(root, null, key);
        if(target==null) return root;
       if(parent==null&&target.value==key) return deleteProcess(target.left, target.right);
       if(parent.value> target.value) parent.left = deleteProcess(target.left, target.right);
       else parent.right = deleteProcess(target.left, target.right);
       return root;
    }

    private static void findTargetAndParent(TreeNode root, TreeNode par, int key){
        if(root==null) return;
        if(root.value==key){
            target=root;
            parent = par;
            return;
        }
        findTargetAndParent(root.left, root, key);
        findTargetAndParent(root.right, root, key);
    }

    private static TreeNode deleteProcess(TreeNode l, TreeNode r){
        if(l==null&&r==null) return null;
        if(l==null) return r;
        if(r==null) return l;
        r.left = deleteProcess(l, r.left);
        return r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(null, null, 1);
        deleteNode(root, 0);
    }
}
