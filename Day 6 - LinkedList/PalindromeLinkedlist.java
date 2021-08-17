// Given a list, determine if the list is palindrome or not.

// [https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=36]

// Input: 1 --> 2 --> 3 --> 2 --> 1
// Output: true

// Time complexity: O(N/2 + N/2 + N/2) = O(3N/2), Space complexity: O(1)

public class PalindromeLinkedlist {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    // Find the middle node
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Reverse the right half
    slow.next = reverseList(slow.next);

    // Move slow to the right half
    slow = slow.next;

    // Check if the left half and right half are same
    while (slow != null) {
      if (head.val != slow.val) return false;
      head = head.next;
      slow = slow.next;
    }

    return true;
  }

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode nxt = null;

    while (head != null) {
      nxt = head.next;
      head.next = pre;
      pre = head;
      head = nxt;
    }
    return pre;
  }
}
