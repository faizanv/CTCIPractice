public class MyLinkedList {
  Node head;
  int size;

  MyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  public int add(int data) {
    if (this.head == null) {
      this.head = new Node(data);
      return ++size;
    }
    Node curr = this.head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new Node(data);
    return ++size;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    Node curr = this.head;
    while (curr != null) {
      builder.append(curr.data);
      builder.append(" - ");
      curr = curr.next;
    }
    return builder.toString();
  }

}