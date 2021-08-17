// !Hard Problem
// Given a linked list, reverse the nodes of a linked list `k` at a time and return
// the modified list.

// [https://www.youtube.com/watch?v=Of0HPkk3JgI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34]

// Input: list = 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> X, k = 3
// Output: 3 --> 2 --> 1 --> 6 --> 5 --> 4 -->7 --> 8 --> X

// Time complexity: O(N/K * K) = O(N), Space complexity: O(1)

public class ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) return head;

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode pre = dummy, cur = dummy, nxt = dummy;
    int count = 0;

    while (cur.next != null) {
      cur = cur.next;
      count++;
    }

    while (k <= count) {
      cur = pre.next;
      nxt = cur.next;
      for (int i = 1; i < k; i++) {
        cur.next = nxt.next;
        nxt.next = pre.next;
        pre.next = nxt;
        nxt = cur.next;
      }
      pre = cur;
      count -= k;
    }
    return dummy.next;
  }
}
