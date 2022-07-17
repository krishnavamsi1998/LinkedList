//O(n),O(1)

public class Solution {
  public static Node removeLoop(Node head) {
       
     Node fast,slow;
     slow=fast=head;
      while(fast!=null && fast.next!=null)
      {
          
          
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast)
              //cycle exists
          {
              
              slow=head;
              while(slow!=fast)
              {
                  slow=slow.next;
                  fast=fast.next;
              }
              //start node reached
              Node startNode=slow;
            
              while(fast.next!=startNode)
                     fast=fast.next;
              //fast is just one node before start node of cycle
              fast.next=null;
              return head;
          }
          
      }
      
      return head;
      
      
  }
}
