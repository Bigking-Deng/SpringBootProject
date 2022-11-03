package leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class get_Tree_297 {

    public static String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        preorder(root, res);
        StringBuilder sb = new StringBuilder();
        for(String s:res){
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] list0 = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(list0));
        TreeNode root = buildTree(list);
        return root;
    }

    private static TreeNode buildTree(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode();
        root.value = Integer.parseInt(list.get(0));
        list.remove(0);
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }

    private static void preorder(TreeNode root, List<String> res){
        if(root==null){
            res.add("null");
            res.add(",");
            return;
        }
        res.add(String.valueOf(root.value));
        res.add(",");
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public static void main(String[] args) {
          TreeNode left = new TreeNode(null, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, right, 1);
         String ss = serialize(root);
         TreeNode r = deserialize(ss);
    }
}
