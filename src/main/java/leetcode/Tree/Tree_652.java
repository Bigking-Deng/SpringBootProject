package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree_652 {
    Map<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        buildSubtreeMap(root);
        for(String s:map.keySet()){
            if(map.get(s).size()>1){
                res.add(map.get(s).get(0));
            }
        }
        return res;
    }

    private void buildSubtreeMap(TreeNode root){
        if(root==null) return;
        StringBuilder s = new StringBuilder();
        SerializeTree(root, s);
        String ss = s.toString();

        if(!map.containsKey(ss)){
            map.put(ss, new ArrayList<>());
        }
        List<TreeNode> listNode = map.get(ss);
        listNode.add(root);
        buildSubtreeMap(root.left);
        buildSubtreeMap(root.right);
    }

    private void SerializeTree(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null");
            sb.append(",");
            return;
        }
        sb.append(root.value);
        sb.append(",");
        SerializeTree(root.left, sb);
        SerializeTree(root.right, sb);
    }
}
