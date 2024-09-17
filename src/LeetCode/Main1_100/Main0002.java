package LeetCode.Main1_100;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Main0002 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 遍历两个链表，将两个链表的相应位置相加，注意是否有进位的产生
         */
        ListNode res = new ListNode();
        ListNode cur = res;
        int flag = 0; //表示当前位置的计算是否有进位的产生
        while (l1 != null || l2 != null) {
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int temp = num1 + num2 + flag;
            if (temp >= 10) {
                flag = 1;
                temp = temp - 10;
            } else {
                flag = 0;
            }
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }

}

