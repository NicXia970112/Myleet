import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        String b = scn.nextLine();
        ListNode headA = null;
        ListNode headB = null;
        for(char c: a.toCharArray()) {
            if(headA == null) {
                headA = new ListNode(c - '0');
            } else {
                ListNode node = new ListNode(c - '0');
                node.next = headA;
                headA = node;
            }
        }
        for(char c: b.toCharArray()) {
            if(headB == null) {
                headB = new ListNode(c - '0');
            } else {
                ListNode node = new ListNode(c - '0');
                node.next = headB;
                headB = node;
            }
        }
        Solution.outPutList(Solution.addTwoNumbers(headA,headB));
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int maxSiz = countList(l1) > countList(l2) ? countList(l1) + 1 : countList(l2) + 1;
        for(int i = 0; i < maxSiz; i++)  {
            ListNode node = new ListNode(0);
            if(result == null) {
                result = node;
            } else {
                node.next = result;
                result = node;
            }
        }
        ListNode now = result;
        while (now.next != null) {
            int a = 0, b = 0;
            if(l1 == null) {
                a = 0;
            }
            if(l2 == null) {
                b = 0;
            }

            now.val += l1.val + l2.val % 10;

            now.next.val += (l1.val + l2.val) / 10;

            now = now.next;

        }

        return result;
    }

    public static void outPutList(ListNode lists) {
        ListNode now = lists;
        while(true) {
            System.out.print(now.val);
            if(now.next != null) {
                now = now.next;
            } else {
                break;
            }
        }
    }

    public static int countList(ListNode head) {
        int count = 0;
        while (true) {
            if(head.next == null) {
                count++;
                break;
            }
            head = head.next;
            count ++;
        }
        return  count;
    }
}