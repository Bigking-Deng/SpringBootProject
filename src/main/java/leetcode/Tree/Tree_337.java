package leetcode.Tree;

import java.util.HashMap;

public class Tree_337 {
    class Solution {
        public int rob(TreeNode root) {
            HashMap<TreeNode, Integer> memo = new HashMap<>();
            return robInternal(root, memo);
        }

        public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
            if (root == null) return 0;
            if (memo.containsKey(root)) return memo.get(root);
            int money = root.value;

            if (root.left != null) {
                money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
            }
            if (root.right != null) {
                money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
            }
            int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
            memo.put(root, result);
            return result;
        }


    }
}
