// Merge two sorted linked list (merge in-place)

// [https://www.youtube.com/watch?v=Xb4slcp1U38&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29]

// Input: l1 = [1, 2, 4], l2 = [1, 3, 4]
// Output: [1, 1, 2, 3, 4, 4]

// Time complexity: O(N1+N2), Space complexity: O(1)

public class MergeTwoLists {

  public ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val > l2.val) {
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }

    ListNode res = l1;
    while (l1 != null && l2 != null) {
      ListNode dummy = null;
      while (l1 != null && l1.val <= l2.val) {
        dummy = l1;
        l1 = l1.next;
      }
      dummy.next = l2;
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }
    return res;
  }
}
