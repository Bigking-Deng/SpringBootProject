package leetcode.linkedList;

public class LinkedList_206 {

//    public static ListNode reverse(ListNode head){
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode next = head.next;
//        while(next!=null){
//            cur.next=prev;
//
//            prev=cur;
//            cur=next;
//            next=next.next;
//        }
//        cur.next=prev;
//        return cur;
//    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode reverseHead = reverse(head);
    }
}
