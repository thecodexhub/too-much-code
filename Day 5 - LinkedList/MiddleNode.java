// Given a non-empty singly linked list with head node [head],
// return the middle node of the linked list.
// If there are two middle nodes, return the second one.

// [https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=28]

// Input: [1, 2, 3, 4, 5]
// Output: 3

// Time complexity: O(N/2), Space complexity: O(1)

public class MiddleNode {

  public ListNode findMiddleNode(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast.next != null || fast != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
