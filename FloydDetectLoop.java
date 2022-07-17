//O(n),O(1)
//refer neetcode
class FloydDetectLoop {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // Add code here
        
        if(head==null)
           return false;
           
        Node slow,fast;
        slow=fast=head;
        
        //since we r moving fast 2 times
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
                return true;
            
        }
    
       return false;
    }
}
