/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        int x = l1.val;
        int y = l2.val;
        int sum = x + y;
        int carry = 0;
        
        if (sum > 9){
            sum -= 10;
            carry = 1;
        }
            
        var result = new ListNode(sum);
        var start = result;
        
        while (l1.next != null || l2.next != null){
            if (l1.next == null){
                x = 0;
            }else{
                l1 = l1.next;
                x = l1.val;
            }
            
            if (l2.next == null){
                y = 0;
            }else{
                l2 = l2.next;
                y = l2.val;
            }
            
            sum = carry + x + y;
            
            if (sum > 9){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            result.next = new ListNode(sum);
            result = result.next;
        }
        
        if (carry != 0){
            result.next = new ListNode(carry);
        }
        
        return start;
    }
}