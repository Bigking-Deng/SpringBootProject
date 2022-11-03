package leetcode.Tree;

import java.util.*;


public class Tree_105_106 {
    static Map<Integer, Integer> dict = new HashMap<>();


    private static TreeNode getSubTree(int[] inorder, int[] postorder, int poststart, int postend, int instart, int inend){
        if(poststart>postend||instart>inend) return null;
        int rootval = postorder[postend];
        int inorderrootIndex = dict.get(rootval);
        int leftSubTreeLength = inorderrootIndex - instart;
        int rightSubtreeLength = inend - inorderrootIndex;
        TreeNode cur = new TreeNode();
        cur.value = rootval;
        cur.right = getSubTree(inorder, postorder, postend-rightSubtreeLength, postend-1, inorderrootIndex+1, inend );
        cur.left = getSubTree(inorder, postorder, poststart, poststart+leftSubTreeLength-1,instart, inorderrootIndex-1 );
        return cur;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++){
            dict.put(inorder[i], i);
        }
        TreeNode root = getSubTree(inorder, postorder, 0, postorder.length-1, 0, inorder.length-1);
        return root;
    }

    public static void main(String[] args) {


    }


}
