// Given a linkedlist of size N, where every node represents a linked list and contains two types of pointer:
// 1. a [next] pointer to the next node,
// 2. a [bottom] pointer to the linked list where this node is head.
// The flattened list will be printed using [bottom] pointer.

// Time complexity: O(N), Space complexity: O(1)

public class FlattenLinkedlist {

  public Node mergeTwoLists(Node a, Node b) {
    Node temp = new Node(0);
    Node res = temp;

    while (a != null && b != null) {
      if (a.val < b.val) {
        temp.bottom = a;
        temp = temp.bottom;
        a = a.bottom;
      } else {
        temp.bottom = b;
        temp = temp.bottom;
        b = b.bottom;
      }
    }

    if (a != null) temp.bottom = a; else temp.bottom = b;
    return res.bottom;
  }

  public Node flatten(Node root) {
    if (root == null || root.next == null) {
      return root;
    }

    // Recur for list on right
    root.next = flatten(root.next);

    // now merge
    root = mergeTwoLists(root, root.next);

    // return the root
    // it will be in turn merged with its left
    return root;
  }
}
