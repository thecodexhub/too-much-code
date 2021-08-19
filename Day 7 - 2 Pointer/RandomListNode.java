// Definition for Singly LinkedList with next and random pointer

public class RandomListNode {

  int val;
  RandomListNode next;
  RandomListNode random;

  RandomListNode() {}

  RandomListNode(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  RandomListNode(int val, RandomListNode next, RandomListNode random) {
    this.val = val;
    this.next = next;
    this.random = random;
  }
}
