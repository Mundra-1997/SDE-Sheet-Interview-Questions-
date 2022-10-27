/*   Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
      Deque<ListNode> q = new ArrayDeque<>();
      while(head != null){
          q.add(head);
          head = head.next;
      }
      while(q.size()>1){
          ListNode first = q.removeFirst();
          ListNode last = q.removeLast();
          if(first.val != last.val) return false;
      }
     return true;
    }
}
