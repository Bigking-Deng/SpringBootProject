package leetcode.Tree;

import java.util.*;

public class Tree_199 {

    private List<Integer> getRightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                if(i==0){
                    res.add(cur.value);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
