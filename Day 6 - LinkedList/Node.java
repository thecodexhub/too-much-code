// Definition for Singly LinkedList with bottom and next pointer

public class Node {

  int val;
  Node next;
  Node bottom;

  Node() {}

  Node(int val) {
    this.val = val;
    this.next = null;
    this.bottom = null;
  }

  Node(int val, Node next, Node bottom) {
    this.val = val;
    this.next = next;
    this.bottom = bottom;
  }
}
