// Write a function to delete a node in singly linked list. You will not be given access
// to the head of the list, instead you will be given access to the node to be deleted directly.

// [https://www.youtube.com/watch?v=icnp4FJdZ_c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=31]

// Time complexity: O(1), Space complexity: O(1)

public class DeleteNode {

  public void deleteNode(ListNode node) {
    if (node.next == null) node = null; 
    else {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
}
