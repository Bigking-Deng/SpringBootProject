package leetcode.hashmap;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    Map<Integer, DoubleListNode> map;
    DoubleListNode dummyHead;
    DoubleListNode tail;
    int cap;

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        dummyHead = new DoubleListNode();
        cap = capacity;
        tail = dummyHead;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DoubleListNode node = map.get(key);
        DoubleListNode curNode = removeFromList(node);
        insertToTail(curNode);
        return node.value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            DoubleListNode node = new DoubleListNode();
            node.value = value;
            node.key = key;
            map.put(key, node);
            insertToTail(node);
            while(map.size()>cap){
                DoubleListNode curNode = removeFromList(dummyHead.nextNode);
                map.remove(curNode.key);
            }
        }else{
            DoubleListNode node = map.get(key);
            node.value=value;
            removeFromList(node);
            insertToTail(node);
        }

    }

    public void insertToTail(DoubleListNode node){
        tail.nextNode = node;
        node.prevNode = tail;
        node.nextNode = null;
        tail = node;
    }

    public DoubleListNode removeFromList(DoubleListNode node){
        if(tail==node){
            tail=node.prevNode;
            tail.nextNode = null;
            node.prevNode=null;
        }else{
            node.prevNode.nextNode=node.nextNode;
            node.nextNode.prevNode=node.prevNode;
            node.prevNode=null;
            node.nextNode=null;
        }
        return node;
    }

    public static void main(String[] args) {
        LRUCache_146 instanceUtils = new LRUCache_146(3);
        instanceUtils.put(1, 1);
        instanceUtils.put(2, 2);
        instanceUtils.put(3, 3);
        int res1 = instanceUtils.get(1);
        instanceUtils.put(4, 4);
        res1 = instanceUtils.get(1);
        res1 = instanceUtils.get(2);
    }

}



@Data
class DoubleListNode{
    public int key;
    public int value;
    public DoubleListNode prevNode;
    public DoubleListNode nextNode;
}
