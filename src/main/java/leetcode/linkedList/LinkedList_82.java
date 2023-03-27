package leetcode.linkedList;

public class LinkedList_82 {
    public ListNode deleteDuplicates1(ListNode head) {
//        ListNode left = null;
//        ListNode right = head;
//        while(right!=null){
//            left=right;
//            while(right!=null && right.val== left.val){
//                right=right.next;
//            }
//            left.next=right;
//        }
//        return head;

        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicates2(ListNode head){
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
    }
}
