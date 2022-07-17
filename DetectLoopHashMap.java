//O(n),O(n)
class DetectLoopHashMap {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){      
        
        if(head==null)
           return false;
           
        
        HashSet<Node> set=new HashSet<>();
        Node temp=head;
        while(temp!=null)
        {
            if(!set.add(temp))
                return true;
            temp=temp.next;
        }
        return false;
        
    }
}
