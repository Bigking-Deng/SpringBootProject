package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree_863 {
    static Map<Integer, List<Integer>> dict = new HashMap<>();
    static List<Integer> result = new ArrayList<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> path = new ArrayList<>();
        buildDict(root, null);
        path.add(target.value);
        DFS(path,  k);
        return result;
    }

    private static void DFS(List<Integer> path, int step){
//        if(!dict.containsKey(key)) return;
        int remainStep = step - 1;
        int key = path.get(path.size()-1);
        List<Integer> cur = dict.get(key);
        if(remainStep==0) {
            for(int val:cur){
                if(!path.contains(val)){
                    result.add(val);
                }
            }
            return;
        }

        for(int val:cur){
            if(!path.contains(val)){
                path.add(val);
                DFS(path,  remainStep);
            }
        }

        path.remove(path.size()-1);
    }

    private static void buildDict(TreeNode root, TreeNode parent){
        if(root==null) return;
        if(!dict.containsKey(root.value)) dict.put(root.value, new ArrayList<>());
        List<Integer> cur = dict.get(root.value);
        if(parent!=null) cur.add(parent.value);
        if(root.left!=null) cur.add(root.left.value);
        if(root.right!=null) cur.add(root.right.value);
        buildDict(root.left, root);
        buildDict(root.right, root);

    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(null, null, 0);
        TreeNode t8 = new TreeNode(null, null, 8);
        TreeNode t4 = new TreeNode(null, null, 4);
        TreeNode t7 = new TreeNode(null, null, 7);
        TreeNode t6 = new TreeNode(null, null, 6);
        TreeNode t2 = new TreeNode(t7, t4, 2);
        TreeNode t5 = new TreeNode(t6, t2, 5);
        TreeNode t1 = new TreeNode(t0, t8, 1);
        TreeNode t3 = new TreeNode(t5, t1, 3);

        buildDict(t3, null);
        List<Integer> path = new ArrayList<>();
        path.add(1);
        DFS(path, 3);
    }
}
