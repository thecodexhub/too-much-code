// Reverse a singly linked list

// [https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=27]

// Input: 1 --> 2 --> 3 --> 4 --> 5 --> null
// Output: null --> 1 --> 2 --> 3 --> 4 --> 5

// Time complexity: O(N), Space complexity: O(1)

public class ReverseLinkedList {

  public ListNode reverse(ListNode head) {
    ListNode dummyHead = null, next;
    while (head != null) {
      next = head.next;
      head.next = dummyHead;
      dummyHead = head;
      head = next;
    }
    return dummyHead;
  }
}
