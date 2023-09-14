package leetcode.hashmap;


public class DesignHashMap_706 {
    ListNode[] arrayTable;

    public DesignHashMap_706() {
        arrayTable = new ListNode[9999];
    }

    public void put(int key, int value) {
        int bucketNum = key%arrayTable.length;
        ListNode dummyHead = arrayTable[bucketNum];
        if(dummyHead==null){
            dummyHead=new ListNode();
            arrayTable[bucketNum]=dummyHead;
        }
        ListNode cur = dummyHead.next;
        ListNode prev = dummyHead;
        while(cur!=null){
            if(cur.key==key){
                cur.value=value;
                return;
            }
            prev=prev.next;
            cur=cur.next;
        }
        ListNode newNode = new ListNode();
        newNode.key=key;
        newNode.value=value;
        prev.next=newNode;
    }

    public int get(int key) {
        int bucketNum = key%arrayTable.length;
        ListNode dummyHead = arrayTable[bucketNum];
        if(dummyHead==null) return -1;
        ListNode cur = dummyHead.next;
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }
            cur=cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int bucketNum = key%arrayTable.length;
        ListNode dummyHead = arrayTable[bucketNum];
        if(dummyHead==null) return;
        ListNode cur = dummyHead.next;
        ListNode prev = dummyHead;
        while(cur!=null){
            if(cur.key==key){
               prev.next=cur.next;
               return;
            }
            prev=prev.next;
            cur=cur.next;
        }
    }


    public static void main(String[] args) {
        DesignHashMap_706 instance = new DesignHashMap_706();
        instance.put(1,1);
        instance.put(2,2);
        int i1 = instance.get(1);
        int i2 = instance.get(2);
        instance.remove(1);
        int i3 = instance.get(1);
        instance.remove(2);
        int i4 = instance.get(3);
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;

}
