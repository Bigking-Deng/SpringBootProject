package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_95_96 {

    //官方第95题动态规划解法，否则递归解法会超时
//    class Solution {
//
//        public int numTrees(int n) {
//            int total = 0;
//
//            int dp[] = new int[n+1];
//            dp[0]=1;
//            dp[1]=1;
//            for(int k=2; k<=n; k++){
//                for(int i=1; i<=k; i++){
//                    dp[k] += dp[i-1]*dp[k-i];
//                }
//            }
//            return dp[n];
//        }
//    }

    private static int getNumOfTree(int start, int end)
    {
        if(start>end) return 1;
        int totalNum = 0;
        for(int i = start; i<=end; i++){
           int root = i;
           int leftNum = getNumOfTree(start, root-1);
           int rightNum = getNumOfTree(root+1, end);
           totalNum+=leftNum*rightNum;
        }
        return totalNum;

    }

    private static List<TreeNode> getTreeList(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }

        for(int i = start; i<=end; i++){
            int root = i;
            List<TreeNode> list1 = getTreeList(start, root-1);
            List<TreeNode> list2 = getTreeList(root+1, end);

            for(TreeNode l:list1){
                for(TreeNode r:list2){
                    TreeNode rootNode = new TreeNode();
                    rootNode.value = root;
                    rootNode.left = l;
                    rootNode.right = r;
                    res.add(rootNode);
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int n = 3;
        int NumberOfBinaryTree = getNumOfTree(1, n);
        List<TreeNode> list = getTreeList(1, n);
        System.out.println(list.size());

    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;
    public TreeNode(){}
    public TreeNode(TreeNode left, TreeNode right, Integer val){
        this.left = left;
        this.right = right;
        this.value =val;
    }
}
