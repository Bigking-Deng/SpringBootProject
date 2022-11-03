package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_230 {
    public int kthSmallest(TreeNode root, int k) {
        int t = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            t++;
            if(t==k){
                return root.value;
            }
            root=root.right;
        }
        return -1;
    }
}
