// Write a program to find the node at which the intersection of singly linkedlist begins.

// [https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34]

// Time complexity: O(2M), Space complexity: O(1)

public class IntersectionNode {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
      // for the end of first iteration, we just reset the pointer to the head of another linkedlist
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }

    return a;
  }
}
