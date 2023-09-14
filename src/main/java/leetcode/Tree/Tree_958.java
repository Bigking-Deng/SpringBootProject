package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        int count=0;
        queue.offer(root);
        queue1.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                int num = queue1.poll();
                count++;
                if(num+1!=count) return false;
                if(cur.left!=null){
                    queue.offer(cur.left);
                    queue1.offer(num*2+1);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    queue1.offer(num*2+2);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
