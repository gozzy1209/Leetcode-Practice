package LinkedList;

public class MergeTwoSortedLists {
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
    public ListNode mergeTwoLists_2ndtry(ListNode list1, ListNode list2) {
        ListNode cur1=list1;
        ListNode cur2=list2;
        //important
        ListNode finalres=new ListNode();
        ListNode res=finalres;
        while(cur1!=null&&cur2!=null){
           if(cur1.val<=cur2.val){
            res.next=cur1;
            cur1=cur1.next;
           } 
           else {res.next=cur2;
           cur2=cur2.next;
           }
           //important
           res=res.next;
        }
        if(cur1!=null) res.next=cur1;
        else if(cur2!=null){res.next=cur2;}
        return finalres.next;
    }
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

