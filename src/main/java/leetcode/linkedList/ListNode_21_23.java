package leetcode.linkedList;

import java.util.PriorityQueue;

public class ListNode_21_23 {

    public static ListNode mergeList(ListNode head1, ListNode head2){
        ListNode l1 = head1;
        ListNode l2 = head2;
        ListNode newHead  = new ListNode(-1);
        ListNode ll = newHead;
        while(l1!=null && l2!=null){
            if(l1.val< l2.val){
                ll.next=l1;
                l1=l1.next;
            }else {
                ll.next=l2;
                l2=l2.next;
            }
            ll=ll.next;
        }
        if(l1!=null){
            ll.next=l1;
        }else{
            ll.next=l2;
        }
        return newHead.next;
    }

    public static ListNode mergeKLists(ListNode[] listNodes){
        ListNode newHead = new ListNode(-1);
        ListNode newPoint = newHead;
//        ListNode[] pt = new ListNode[listNodes.length];
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a,b)->{return a.val-b.val;});
        for(int i=0; i<listNodes.length; i++){
//            pt[i]=listNodes[i];
            priorityQueue.add(listNodes[i]);
        }
        while(!priorityQueue.isEmpty()){
            ListNode cur = priorityQueue.poll();
            newPoint.next = cur;
            newPoint = newPoint.next;
            cur = cur.next;
            if(cur!=null){
                priorityQueue.add(cur);
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(7, new ListNode(16, null))));
        ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode head2 = new ListNode(3, new ListNode(4, new ListNode(22, new ListNode(26, null))));
        ListNode head3 = new ListNode(1, null);
        ListNode head4 = new ListNode(6, new ListNode(7, null));

        ListNode node = mergeKLists(new ListNode[]{head, head1, head2, head3, head4});
    }
}
