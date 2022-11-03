package leetcode.Tree;

public class Tree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(root.value>p.value&&root.value>q.value){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.value<p.value&&root.value<q.value){
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.value==p.value) return p;
        else if(root.value==q.value) return q;
        else return root;

    }
}
