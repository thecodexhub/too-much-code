// Given the head of the linked list [head], remove [n]-th node from the end
// of the list and return its head.

// [https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=30]

// Input: [1 --> 2 --> 3 --> 4 --> 5], n = 2
// Output: [1 --> 2 --> 3 --> 5]

// Time complexity: O(N), Space complexity: O(1)

public class RemoveNthFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode();
    start.next = head;
    ListNode slow = start, fast = start;

    for (int i = 0; i < n; i++) fast = fast.next;

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return start.next; // Not return head; [Check if n = size of the node]
  }
}
