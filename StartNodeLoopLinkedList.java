//O(n),O(n)
//return start node of loop else null if loop not there
public class Solution {
    public ListNode StartNodeLoopLinkedList(ListNode head) {
        
        
        Set<ListNode> set=new HashSet<>();
        
        ListNode temp=head;
        
       
        while(temp!=null)
        {
            if(!set.add(temp))
                return temp;
            temp=temp.next;
        }
        return null;
      
    }
}
