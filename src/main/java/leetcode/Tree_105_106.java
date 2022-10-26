package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;


public class Tree_105_106 {

    private static TreeNode getTreeNode(List<Integer> preorderList, List<Integer> inorderList){
        int rootVal = preorderList.get(0);
        TreeNode rootNode = new TreeNode();
        rootNode.value = rootVal;
        int rootIndex = inorderList.indexOf(rootVal);
        if(rootIndex==0){
            rootNode.left = null;
            rootNode.right = getTreeNode(preorderList.subList(1, preorderList.size()), inorderList.subList(rootIndex+1, inorderList.size()));
        }
        if(rootIndex==inorderList.size()-1){
            rootNode.right = null;
            rootNode.left = getTreeNode(preorderList.subList(1, preorderList.size()), inorderList.subList(0, inorderList.size()-1));
        }
        if(rootIndex>0 && rootIndex<inorderList.size()-1){
            int leftNum = rootIndex;
            rootNode.left = getTreeNode(preorderList.subList(1, 1 + leftNum), inorderList.subList(0, rootIndex));
            rootNode.right = getTreeNode(preorderList.subList(1 + leftNum, preorderList.size()), inorderList.subList(rootIndex + 1, inorderList.size()));
        }
        return rootNode;
    }


    public static void main(String[] args) {


    }


}
