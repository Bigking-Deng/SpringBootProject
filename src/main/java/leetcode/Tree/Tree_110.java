package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

public class Tree_110 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right))<=1){
            return true;
        }
        return false;
    }

    public int getHeight(TreeNode root){
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int max = Math.max(getHeight(root.left), getHeight(root.right));
        map.put(root,max+1);
        return max+1;
    }

    public static void main(String[] args) {

    }
}
