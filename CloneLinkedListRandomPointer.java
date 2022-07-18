//O(n),O(n)
//refer neetcode
class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null)
        {
            Node copy=new Node(curr.val);
            map.put(curr,copy);
            curr=curr.next;
        }
        
        curr=head;
        while(curr!=null)
        {
            Node copy=map.get(curr);
            copy.next=map.get(curr.next);
            copy.random=map.get(curr.random);
            curr=curr.next;
        }
        
        return map.get(head);
    }
}
