package LinkedList;

import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.RunElement;

//206. Reverse Linked List
/*Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        //iterative方法
        ListNode pre=null;
        ListNode cur=head;
        //we don't use cur.next!=null,because we allow cur.next is null，but don't allow sth like null.next
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    public ListNode reverseList_2nd(ListNode head) {
        //recursive方法
        //先判断当前结点head是不是空结点或者是tail结点（head。next==null）
        if(head == null || head.next == null){
            return head;
        }
        //如果不是
        //对当前结点的下一个结点进行回溯
        //ListNode newnode这一步很重要，想想为什么要多次一举创建newnode，相当于temp
        //为什么是reverseList(head.next)，而不是reverseList(head)
        ListNode newnode=reverseList_2nd(head.next);
        //进行当前结点的反转操作
        //让下个结点指向当前结点
        head.next.next=head;
        //让当前结点指向null
        head.next=null;
        //回溯方法中的return这个地方一定是，没到最后那个点我就不返回实际值先
        return newnode;
    }
    public ListNode reverseList_3rd(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        //because cur is null and pre isn't null
        return pre;
    }
    public ListNode reverseList_4th(ListNode head) {
        //recursive again
         if(head==null||head.next==null){
            return head;
         }
         ListNode finalnode=head;
         //为什么递归不能用iteration里面的pre结点方法，因为唯一的传递参数只有当前结点head，我们不知道它的过去，因此只能让它的未来指向它的现在
         finalnode=reverseList_4th(head.next);
         head.next.next=head;
         head.next=null;
         return finalnode;



    class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
}
