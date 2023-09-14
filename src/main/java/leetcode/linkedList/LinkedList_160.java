package leetcode.linkedList;

public class LinkedList_160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode pa = headA; ListNode pb = headB;
        while(true){
            if(pa==null && pb==null) return null;
            if(pa==null) pa=headB;
            if(pb==null) pb=headA;
            if(pa==pb) break;
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
//        while(pa!=pb){
//            pa=pa==null?headB:pa.next;
//            pb=pb==null?headA:pb.next;
//        }
//        return pa;
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(2);
        ListNode headB = new ListNode(3);
        headA.next = headB;
        getIntersectionNode(headA, headB);
    }
}
