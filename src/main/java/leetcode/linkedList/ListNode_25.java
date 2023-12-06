package leetcode.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ListNode_25 {
    public static ListNode[] reverse(ListNode head,ListNode tail){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null && prev!=tail){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return new ListNode[]{prev, head};
    }

    public static ListNode reverseInGroup(ListNode head, int k){
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode left = dummy;
        while(left!=null){
            ListNode right = left;
            for(int i=0; i<k; i++){
                right=right.next;
                if(right==null){
                    return dummy.next;
                }
            }
            ListNode nextStart = right.next;
            ListNode[] newHead = reverse(left.next, right);
            left.next=newHead[0];
            newHead[1].next=nextStart;
            left=newHead[1];
        }
       return dummy.next;

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
        //ListNode newHead = reverseInGroup(head, 2);
        ListNode newHead = reverseInGroup(head, 3);
        System.out.println("----");

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(4, (a,b)->a.val-b.val);
    }
}
