package my;


/** 
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        
        ListNode a = root;
        ListNode b = root;
        
        for (int i = 0; i < n; i++) {
        	a = a.next;
        }
        while (a.next != null) {
        	a = a.next;
        	b = b.next;
        }
        b.next = b.next.next;
        return root.next;
    }
}