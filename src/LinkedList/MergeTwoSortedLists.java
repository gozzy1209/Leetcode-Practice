package LinkedList;

public class MergeTwoSortedLists {
    
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

class Solution {
       public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
           //比较当前结点谁大
           //把新节点=当前较小结点
           //当前较小结点.next
           //继续下一轮比较

           //设置dummy假节点很重要
           ListNode dummy=new ListNode();
           ListNode newnode=dummy;
           while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                //必须是newnode.next=list1;而不能是newnode=list1;为什么？
                newnode.next=list1;
                list1=list1.next;
            }
            else{
                newnode.next=list2;
                list2=list2.next;
            }
            newnode=newnode.next;
           }
           if(list1!=null){
            //一行newnode.next=list1;直接把list1剩余部分全复制，好好记下来
            newnode.next=list1;
           }
           else if(list2!=null){
            newnode.next=list2;
           }
           //为什么必须是return dummy.next;
           return dummy.next;
       }
    }