package LinkedList;

import java.nio.file.FileStore;

//143. Reorder List
/*You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed. */
public class ReorderList {
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public void reorderList(ListNode head) {
        //思路大概懂了，代码大部分也正确，但是真的实现不了!!!
       
       
        //把linked list分为前后两部分
       //对后半部分second 进行反转
       //对于前半部分和后半部分进行交叉合并

       if(head==null||head.next==null) return;

       //find middle，通过slow找到中间值把linked list分为两部分
       ListNode slow=head;
       ListNode fast=head.next;
       while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }

       //reverse反转
       //why slow.next? think about it 
       ListNode pre=slow;
       ListNode cur=slow.next;
       while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }

       //merge
       ListNode first=head;
       ListNode second=pre;//pre is the last(big) element
       while(second!=first){
        ListNode temp1=first.next;
        ListNode temp2=second.next;
        first.next=second;
        second.next=first;
        first=temp1;
        second=temp2;
       }


    }
    
   }