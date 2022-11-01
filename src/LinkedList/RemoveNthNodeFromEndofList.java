package LinkedList;
//19. Remove Nth Node From End of List
/*Given the head of a linked list, remove the nth node from the end of the list and return its head. */
public class RemoveNthNodeFromEndofList {
    
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

   class Solution {
       public ListNode removeNthFromEnd(ListNode head, int n) {
        //先反转一次
        //正序跳过特定元素
        //再反转一次

        //更优解：通过左右指针（右指针跳的比左快）之间的gap来解决，可以思考
        ListNode dummy= reverseList(head);
        ListNode pre=dummy;
        if(n==1){
            dummy=dummy.next;
            return reverseList(dummy);
        }
        else{
         int i=2;
         while(i<n){
         dummy=dummy.next;
         i++;
         }
         if(dummy.next!=null){
            dummy.next=dummy.next.next;
         }
        }
        return reverseList(pre);
    }
    ListNode reverseList(ListNode head) {
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

    class solution_2{
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //快慢指针来求解
            ListNode start = new ListNode(0);
            ListNode slow = start, fast = start;
            slow.next = head;
            //i=1;i<=n+1 很关键
            for(int i=1;i<=n+1;i++){
                fast=fast.next;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return start.next;
        }
    }
   }
