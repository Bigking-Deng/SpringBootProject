package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tree_449 {

    private static List<Integer> SerializeTree(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private static void preOrder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private static TreeNode DeserializeTree(List<Integer> list){
        if(list.size()==0) return null;
        Integer root = list.get(0);
        int index = 1;
        for(int i = 1 ; i < list.size(); i++){
            if(list.get(i)>root){
                index = i;
                break;
            }
        }
        if(index == 1) index = list.size();
        List<Integer> leftList = list.subList(1, index);
        List<Integer> rightList = list.subList(index, list.size());
        TreeNode left = DeserializeTree(leftList);
        TreeNode right = DeserializeTree(rightList);
        TreeNode cur = new TreeNode(left, right, root);
        return cur;
    }


    public static void main(String[] args) {

    }
}
