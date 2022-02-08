package leetcode.editor.cn;//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 785 👎 0


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
class Solution143 {

    public static class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // 1、 找到链表的中间节点 2、将中间节点后面的链表反向转换 3、两个链表进行交叉插入
        ListNode middleNode = findMiddleNode(head);

        ListNode head1 = head;
        ListNode head2 = middleNode.next;
        middleNode.next = null;

        ListNode reverseHead2 = reverseNode(head2);

        ListNode ite2 = reverseHead2;
        ListNode ite1 = head1;
        while(ite2 != null){
            ListNode temp1 = ite1;
            ListNode temp2 = ite2;

            ite1 = ite1.next;
            ite2 = ite2.next;

            temp2.next = ite1;
            temp1.next = temp2;
        }
    }

    public ListNode reverseNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        ListNode next = current.next;
        while(current != null ){
            current.next = pre;

            pre = current;
            current = next;
            if(next != null){
                next = next.next;
            }

        }

        return pre;
    }

    public ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode twoStep = head;
        ListNode oneStep = head;
        ListNode oneStepBack = oneStep;
        while(twoStep != null && twoStep.next != null){
            oneStepBack = oneStep;
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
        // 1 2 3 4
//        if(twoStep != null){
//            return oneStepBack;
//        }else {
//            return oneStep;
//        }
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        solution143.reorderList(listNode1);

        ListNode temp = listNode1;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
