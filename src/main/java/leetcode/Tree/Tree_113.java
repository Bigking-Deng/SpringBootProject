package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        getPath(root, targetSum, new ArrayList<>(),res);
        return res;
    }

//    private void getPath(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> res){
//        if(root==null) return;
//        if(root.left==null&&root.right==null&&root.value==targetSum){
//            currentPath.add(root.value);
//            res.add(new ArrayList<>(currentPath));
//            currentPath.remove(currentPath.size()-1);
//            return;
//        }
//        currentPath.add(root.value);
//        getPath(root.left, targetSum- root.value, currentPath, res);
//        getPath(root.right, targetSum- root.value, currentPath, res);
//        currentPath.remove(currentPath.size()-1);
//    }

    private void getPath(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> res){
        if(root==null) return;
        if(root.left==null && root.right == null){
            if(targetSum - root.value==0){
                currentPath.add(root.value);
                ArrayList<Integer> copy = new ArrayList<>(currentPath);
                res.add(copy);
                currentPath.remove(currentPath.size()-1);
            }
        }
        currentPath.add(root.value);
        getPath(root.left, targetSum- root.value, currentPath, res);
        getPath(root.right, targetSum- root.value, currentPath, res);
        currentPath.remove(currentPath.size()-1);
    }
}
