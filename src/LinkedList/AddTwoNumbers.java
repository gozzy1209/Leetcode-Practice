package LinkedList;

public class AddTwoNumbers {
class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //这题只能每次相加后添加到node中，不能全部加完再一起添加到新node我也不知道为啥
        int sum=0;
        ListNode res=new ListNode(0);
        ListNode temp=res;
        while(l1!=null||l2!=null||sum!=0){
        if(l1!=null){
            sum+=l1.val;
            l1=l1.next;
        }
        if(l2!=null){
            sum+=l2.val;
            l2=l2.next;
        }
        temp.next=new ListNode(sum%10);
        //sum包含进位 carry
        sum/=10;
        temp=temp.next;
        }
        return res.next;
}
}
}

