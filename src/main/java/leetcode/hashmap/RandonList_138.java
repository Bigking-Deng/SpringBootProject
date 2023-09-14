package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RandonList_138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMapping = new HashMap<>();
        Map<Node, Node> randomMapping = new HashMap<>();
        Node cur=head;
        while(cur!=null){
            Node newNode = new Node(cur.val);
            oldToNewMapping.put(cur, newNode);
            randomMapping.put(cur, cur.random);
            cur=cur.next;
        }
        Node dummy = new Node(-1);
        Node curNew = dummy;
        Node curOld = head;
        while(curOld!=null){
            curNew.next = oldToNewMapping.get(curOld);
            oldToNewMapping.get(curOld).random = oldToNewMapping.get(randomMapping.get(curOld));
            curNew=curNew.next; curOld=curOld.next;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
