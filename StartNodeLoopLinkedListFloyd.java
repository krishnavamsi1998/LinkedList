//O(n),O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
       ListNode slow,fast;
        slow=fast=head;
        // we should use &&
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
               //here fast and slow are equal
                return slow;
                    
            }
            
        }
        return null;
    }
}
