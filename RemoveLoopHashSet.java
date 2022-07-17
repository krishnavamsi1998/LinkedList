import java.util.HashSet;

//O(n),O(1)

public class RemoveLoopHashSet {
  public static Node removeLoop(Node head) {
       
      Node prev=null;
      Node curr=head;
      HashSet<Node> set=new HashSet<>();
      
      while(curr!=null)
      {
          if(!set.add(curr))
          {
              prev.next=null;
              return head;
          }
          prev=curr;
          curr=curr.next;
      }
      
      return head;
      
  }
}
