
public class Test {
    public static void main (String []args) {
        ListNode []lists = new ListNode[5];
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new ListNode(i);
        }
        for(int i = 0; i < lists.length; i++) {
            if( i == lists.length - 1) {
                break;
            }
            lists[i].next = lists[i + 1];
        }
        Method m = new Method();
        //m.log(lists[0]);
        ListNode head =  m.RemoveNthNode(lists[0],4);
        m.log(head);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Method {
    public ListNode RemoveNthNode(ListNode head, int n) {
        if(n == 0) {
            return head.next;
        }
        ListNode node = head;
        for(int i = 0; i < n - 1; i++) { //找到第n-1个节点
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    public void log(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            if(head.next == null) {
                break;
            }
            head = head.next;
        }
    }
}

