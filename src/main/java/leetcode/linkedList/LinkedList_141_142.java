package leetcode.linkedList;

public class LinkedList_141_142 {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast==null || fast.next==null) return false;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        if(fast==null) return false;
        return true;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int ct=0;
        while(true){
            if(fast==null || fast.next==null) return null;
            fast=fast.next.next;
            slow=slow.next;
            ct++;
            if(fast==slow) break;
        }
        if(fast==null) return null;
        int ct1 = ct;
        while(true){
            fast=fast.next.next;
            slow=slow.next;
            ct++;
            if(fast==slow) break;
        }
        int ct2 = ct;
        int gap = ct2-ct1;
        fast=head; slow=head;
        for(int i=0; i<gap; i++) fast=fast.next;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        hasCycle(new ListNode(1));
        ListNode head1 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        head1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n1;
        detectCycle(head1);
    }
}
