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
        // temp 和 pre其实都是变量，认真理解这里
        //为什么不需要cur.next!=null,因为允许cur.next为null，但是不允许null.next的出现而已
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        //recursive方法
        //先判断当前结点head是不是空结点或者是tail结点（head。next==null）
        if(head == null || head.next == null){
            return head;
        }
        //如果不是
        //对当前结点的下一个结点进行回溯
        //ListNode newnode这一步很重要，想想为什么要多次一举创建newnode，相当于temp
        //为什么是reverseList(head.next)，而不是reverseList(head)
        ListNode newnode=reverseList2(head.next);
        //进行当前结点的反转操作
        //下一个结点的再下一个结点就是当前结点（相当于反转）
        head.next.next=head;
        //下一个结点变成null，说明上一步的head.next.next就是头节点
        head.next=null;
        //回溯方法中的return这个地方一定是，没到最后那个点我就不返回实际值先
        return newnode;


    }

    class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
}
