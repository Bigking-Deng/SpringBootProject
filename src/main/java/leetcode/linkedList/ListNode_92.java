package leetcode.linkedList;

public class ListNode_92 {

    public static ListNode reversePart(ListNode head, int start, int end){
        ListNode startNode = head;
        ListNode endNode = head;
        for(int i=1; i<start-1;i++){
            startNode=startNode.next;
        }
        for(int i=1; i<end;i++){
            endNode=endNode.next;
        }
        ListNode next = endNode.next;
        endNode.next=null;
        ListNode[] newHead = reverse(startNode.next);
        startNode.next=newHead[1];
        newHead[0].next=next;
        return head;

    }

    public static ListNode[] reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return new ListNode[]{head, prev};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverseHead = reversePart(head, 2,4);
    }
}
