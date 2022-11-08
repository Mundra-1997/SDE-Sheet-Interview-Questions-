/*   You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order. */


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode res;
        ListNode l1;
        ListNode l2;
        if(list1.val>list2.val){
             l1 = list2;
             l2 = list1;
             res = list2;
        }
        else{
             l1 = list1;
             l2 = list2;
             res = list1;
        }
        while(l1 != null && l2 != null){
            ListNode temp = null;
            while(l1 != null && l1.val<=l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            ListNode node = l1;
            l1 = l2;
            l2 = node;
        }
        return res;
    }
}
