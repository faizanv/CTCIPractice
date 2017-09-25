import java.util.*;

public class Chapter2 {
  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    list.add(2);
    list.add(1);
    list.add(3);
    list.add(3);
    list.add(6);
    list.add(1);
    list.add(2);
    System.out.println(list);
    System.out.println(isPalindromeStack(list.head)); 
  }

  // 2.6 with stack
  public static boolean isPalindromeStack(Node node) {
    Node fast = node;
    Node slow = node;
    Stack<Integer> stack = new Stack<>();

    // push first half onto stack
    while (fast != null && fast.next != null) {
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    // odd length list
    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (slow.data != stack.pop()) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  // 2.6 reverse and clone technique
  public static boolean isPalindrome(Node node) {
    Node cur = node;
    Node reversedList = null;
    while (cur != null) {
      Node newNode = new Node(cur.data);
      newNode.next = reversedList;
      reversedList = newNode;
      cur = cur.next;
    }
    // check if reversedList == node
    while (node != null && reversedList != null) {
      if (node.data != reversedList.data) return false;
      node = node.next;
      reversedList = reversedList.next;
    }
    return true;
  }

  // 2.4 Partition list around x
  public static void partition(Node node, int x) {
    Node beforeHead = null;
    Node beforeTail = null;
    Node afterHead = null;
    Node afterTail = null;
    while (node != null) {
      Node next = node.next;
      node.next = null;
      if (node.data < x) {
        // add to before list
        if (beforeHead == null) {
          beforeHead = node;
          beforeTail = beforeHead;
        } else {
          beforeTail.next = node;
          beforeTail = beforeTail.next;
        }
      } else {
        // add to after list
        if (afterHead == null) {
          afterHead = node;
          afterTail = afterHead;
        } else {
          afterTail.next = node;
          afterTail = afterTail.next;
        }
      }
      node = next;
    }
    if (beforeHead == null) {
      node = afterHead;
    } else {
      beforeTail.next = afterHead;
      node = beforeTail;
    }
  }

  // 2.3
  public static void deleteGivenNode(Node node) {
    if (node == null || node.next == null) return;
    
    Node next = node.next;
    node.data = next.data;
    node.next = next.next;
  }

  // 2.2
  public static Node kthToLast(Node head, int k) {
    Node aheadPointer = head;
    Node behindPointer = head;

    // Move aheadPointer k nodes away from behindPointer
    for (int i = 0; i < k; i++) {
      if (aheadPointer == null) return null;
      aheadPointer = aheadPointer.next;
    }
    while (aheadPointer.next != null) {
      aheadPointer = aheadPointer.next;
      behindPointer = behindPointer.next;
    }
    return behindPointer;
  }
  
  // 2.1
  public static void deleteDups(Node node) {
    Set<Integer> seen = new HashSet<>();
    Node prev = null;
    while (node != null) {
      if (seen.contains(node.data)) {
        prev.next = node.next;
      } else {
        seen.add(node.data);
        prev = node;
      }
      node = node.next;
    }
  }
}