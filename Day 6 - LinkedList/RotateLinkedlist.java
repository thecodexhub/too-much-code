// Given the [head] of the linked list, rotate the list to the right by [k] places.

// [https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=39]

// Input: list = 1 --> 2 --> 3 --> 4 --> 5, k = 2
// Output: 4 --> 5 --> 1 --> 2 --> 3

// Time complexity: O(N), Space complexity: O(1)

public class RotateLinkedlist {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    ListNode curr = head;
    int len = 1;
    while (curr.next != null) {
      len++;
      curr = curr.next;
    }

    curr.next = head;
    k = k - (k % len);
    while (k > 0) {
      curr = curr.next;
      k--;
    }

    head = curr.next;
    curr.next = null;

    return head;
  }
}
