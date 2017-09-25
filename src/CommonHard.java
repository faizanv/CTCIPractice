import java.util.*;

/**
 * This is a collection of commonly hard problems
 */
public class CommonHard {

    public static void main(String[] args) {
        String input = "1,28,300.6,San Fransisco";
        String[] spl = input.split(",");
        System.out.println(spl[0]);
        System.out.println(spl[1]);
        System.out.println(spl[2]);
        System.out.println(spl[3]);
    }

    /**
     * To reverse a singly linked list you
     * basically are iterating through the list
     * and pointing cur to prev and then return prev
     * at the end as the new head.
     * @param head Head of LinkedList to be reversed
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        // map values of num to their index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // for each num, check if (target - num) exists and return it
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }
}