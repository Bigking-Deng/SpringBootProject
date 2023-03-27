package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS_GRAPH_133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeMap = new HashMap<>();
        return buildNode(node, nodeMap);

    }

    private Node buildNode(Node node, Map<Node, Node> nodeMap){
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        for(Node nei:node.neighbors){
            Node newNei = buildNode(nei, nodeMap);
            if(newNei!=null){
                newNode.neighbors.add(newNei);
            }

        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
