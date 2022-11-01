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
       //把linked list分为前后两部分
       //对后半部分second 进行反转
       //对于前半部分和后半部分进行交叉合并

       if(head==null||head.next==null) return;

       //find middle，通过slow找到中间值把linked list分为两部分
       ListNode slow=head;
       ListNode fast=head.next;
       //核心还是fast.next!=null
       while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }

       //iteration的反转方法
       ListNode cur=slow.next;
       //下面两步实在是太关键了
       slow.next=null;
       ListNode pre=slow.next;
       while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;//当前结点指向pre结点
            pre=cur;//pre结点变当前结点（向右移动一个）
            cur=temp;//当前结点变下一个结点（同样向右移动一个）
        }

       //merge
       ListNode head1=head;
       ListNode head2=pre;//pre is the last(big) element
       while (head2 != null) {
        ListNode next = head1.next;
        head1.next = head2;
        head1 = head2;
        head2 = next;
    }


    }
    
   }