package leetcode.Tree;

public class Tree_687 {



        int maxlen = 0;

        public int longestUnivaluePath(TreeNode root) {
            if(root==null) return 0;
            getLongestPath(root, root.value-1);
            return maxlen;
        }

        private int getLongestPath(TreeNode root, int prev){
            if(root==null) return 0;
            int curlen = 0;
            int left = getLongestPath(root.left, root.value);
            int right = getLongestPath(root.right, root.value);
            curlen = curlen + left + right;
            maxlen = Math.max(maxlen, curlen);
            if(root.value == prev){
                return 1 + Math.max(left, right);
            }
            else return 0;
        }


}
