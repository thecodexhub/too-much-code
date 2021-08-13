// You are given two non-empty linked lists representing non-negative integers.
// the digits are stored in reverse order, each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.

// [https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=32]

// Input: l1 = 2 --> 4 --> 3, l2 = 5 --> 6 --> 4
// Output: 7 --> 0 --> 8

// Time complexity: O(N1+N2), Space complexity: O(1)

public class AddTwoNumbers {

  public ListNode addtwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode temp = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      sum += carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      temp.next = node;
      temp = temp.next;
    }
    return dummy.next;
  }
}
