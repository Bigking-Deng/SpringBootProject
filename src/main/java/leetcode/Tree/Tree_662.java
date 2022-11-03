package leetcode.Tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_662 {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qs = new LinkedList<>();
        q.offer(root);
        qs.offer(1);
        while(!q.isEmpty()&&!qs.isEmpty()){
            int start = 0, end = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                int num = qs.poll();
                if(i==0){
                    start = num;
                }
                if(i==size-1){
                    end = num;
                }
                TreeNode cur = q.poll();
                if(cur.left!=null){
                    q.offer(cur.left);
                    qs.offer(2*num);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                    qs.offer(2*num+1);
                }
            }
            maxWidth = Math.max(end - start + 1, maxWidth);
        }
        return maxWidth;
    }
}
