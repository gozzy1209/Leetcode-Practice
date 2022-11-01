package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    class Solution {
        public Node copyRandomList(Node head) {
            //不是太懂，多做几遍
            if(head==null)return null;
            Map<Node,Node> map=new HashMap<>();
            //loop1: copy all nodes
            Node cur=head;
            while(cur!=null){
                map.put(cur, new Node(cur.val));
                cur=cur.next;
            }

            //loop2: assign next and random pointers
            cur=head;
            while(cur!=null){
                map.get(cur).next=map.get(cur.next);
                map.get(cur).random=map.get(cur.random);
                cur=cur.next;
            }
            return map.get(head);
        }
    }
}
