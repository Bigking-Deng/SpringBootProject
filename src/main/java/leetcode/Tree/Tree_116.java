package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_116 {

    private void LinkNodes(TreeNode2 root){
        Queue<TreeNode2> queue = new LinkedList<>();
        if(root==null) return;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode2 prev = null;
            for(int i = 0; i<size; i++){
                TreeNode2 cur = queue.poll();
                if(i!=0){
                    prev.next = cur;
                }
                if(i==size-1){
                    cur.next = null; 
                }
                prev = cur;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                
            }
        }
    }

    public static void main(String[] args) {

    }
}
class TreeNode2{
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;
    int value;
}
