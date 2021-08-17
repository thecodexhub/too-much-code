// Given a node, return the node where the cycle begins.
// If there is no cycle, return [null]

// [https://www.youtube.com/watch?v=QfbOhn0WZ88&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=37]

// Time complexity: O(N), Space complexity: O(1)

public class StartPointLinkedlist {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next;

      if (slow == fast) {
        ListNode entry = head;
        while (entry != slow) {
          entry = entry.next;
          slow = slow.next;
        }
        return entry;
      }
    }

    return null;
  }
}
