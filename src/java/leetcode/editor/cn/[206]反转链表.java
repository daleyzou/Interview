package leetcode.editor.cn;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1948 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next== null){
            return head;
        }
        System.out.println("begin, val:" + head.val);
        ListNode headTemp = head;
        ListNode temp = headTemp.next;
        headTemp.next = null;
        while(temp != null){
            ListNode tempNext = temp.next;
            temp.next = headTemp;
            headTemp = temp;
            temp = tempNext;
        }
        System.out.println("end, val:" + head.val);
        return headTemp;
    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next== null){
            return head;
        }
        System.out.println("begin, val:" + head.val);
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println("end, val:" + head.val);
        return last;
    }


    public static class ListNode {
         int val;
        ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static void main(String[] args){
        Solution206 solution206 = new Solution206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
         ListNode listNode = solution206.reverseList(listNode1);
         while (listNode != null){

             System.out.println(listNode.val);
             listNode = listNode.next;
         }

     }
}
//leetcode submit region end(Prohibit modification and deletion)
