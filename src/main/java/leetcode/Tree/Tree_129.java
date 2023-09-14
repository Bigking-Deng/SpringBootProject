package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_129 {
    static List<Integer> res = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {
        int total = 0;
        getChild(root, "");
        for(int result:res){
            total+=result;
        }
        return total;
    }

    private static void getChild(TreeNode root, String num){
        if(root==null) return;
        num += root.value;
        if(root.left==null && root.right==null ){
            res.add(Integer.valueOf(num));
            return;
        }
        getChild(root.left, num);
        getChild(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(null, null, 0);
        TreeNode t5 = new TreeNode(null, null, 5);
        TreeNode t1 = new TreeNode(null, null, 1);
        TreeNode t9 = new TreeNode(t5, t1, 9);
        TreeNode root = new TreeNode(t9, t0, 4);
        sumNumbers(root);

    }
}
