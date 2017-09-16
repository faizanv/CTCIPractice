public class Node {
  Node next;
  int data;

  Node(int data) {
    this.data = data;
    this.next = null;
  }

  public String toString() {
    return Integer.toString(this.data);
  }
}