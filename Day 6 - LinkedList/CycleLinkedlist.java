// Given [head], the head of a linkedlist, determine if the linkedlist has a cycle in it.

// [https://www.youtube.com/watch?v=354J83hX7RI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34]

// Time complexity: O(N), Space complexity: O(1)

public class CycleLinkedlist {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) return true;
    }

    return false;
  }
}
