package leetCode;

public class AddTwoNumber {
    /*
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their nodes
     * contain a single digit. Add the two numbers and return it as a linked list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     * 
     * Example:
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
     * 465 = 807.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode l1p = l1, l2p = l2;
	while (l1p != null && l2p != null) {
	    l1p.val = l1p.val + l2p.val;
	    if (l1p.val >= 10) {
		ListNode lcp = l1p;
		while (lcp != null && lcp.val >= 10) {
		    lcp.val -= 10;
		    if (lcp.next == null) {
			lcp.next = new ListNode(1);
		    } else {
			lcp.next.val++;
		    }
		    lcp = lcp.next;
		}
	    }

	    if (l1p.next == null) {
		l1p.next = l2p.next;
		l2p.next = null;
	    }
	    l1p = l1p.next;
	    l2p = l2p.next;
	}
	return l1;
    }

    public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }
}
