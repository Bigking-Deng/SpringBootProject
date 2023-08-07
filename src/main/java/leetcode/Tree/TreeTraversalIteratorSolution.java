package leetcode.Tree;

import java.util.*;

public class TreeTraversalIteratorSolution {

    public static void preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode cur = stack.pop();
           list.add(cur.value);
           if(cur.right!=null) stack.push(cur.right);
           if(cur.left!=null) stack.push(cur.left);
        }
    }

    public static void inOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node = stack.pop();
            list.add((node.value));
            if(node.right!=null){
                cur=node.right;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.value);
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        Collections.reverse(list);
    }
}
