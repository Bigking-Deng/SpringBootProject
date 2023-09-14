package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree_236 {

    Map<TreeNode, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        travelToSave(root, null);
        List<TreeNode> list1 = new ArrayList<>();

        TreeNode pv = p;
        TreeNode qv = q;
        while (pv != null) {
            list1.add(pv);
            pv = map.get(pv);
        }
        while (qv != null) {
            if (list1.contains(qv)) {
                return qv;
            }
            qv = map.get(qv);
        }

        return null;
    }

    private void travelToSave(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (parent != null) {
            map.put(root, parent);
        }
        travelToSave(root.left, root);
        travelToSave(root.right, root);
    }


    //递归做法
    class Solution {

        private TreeNode ans;

        public Solution() {
            this.ans = null;
        }

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.value == p.value || root.value == q.value) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.value == p.value || root.value == q.value);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }


    public static void main(String[] args) {

    }
}