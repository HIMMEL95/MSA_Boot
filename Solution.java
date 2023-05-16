import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);

        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ArrayList<Integer> list = new ArrayList();
        int top = 0;
        int no = 0;
        try {
            for (int i = 0; i < 100; i++) {
                // l1, l2 null 여부 파악
                String num1 = Integer.toString(l1.val);
                String num2 = Integer.toString(l2.val);
                if (isInteger(num1) && isInteger(num2)) {
                    // l1, l2 둘 다 null이 아닐 경우
                    no = Integer.parseInt(num1) + Integer.parseInt(num2);

                    if (top == 1) {
                        no += 1;
                    }
                    if (no > 9) {
                        top = 1;
                        no -= 10;
                        list.add(no);
                    } else {
                        top = 0;
                        list.add(no);
                    }

                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    // l1, l2 둘 중 하나는 null인 경우
                    if (isInteger(num1)) {
                        // l2 == null && l1 != null
                        if (top == 1) {
                            no = top + Integer.parseInt(num1);
                            list.add(no);
                        } else {
                            no = Integer.parseInt(num1);
                            list.add(no);
                        }
                    } else if (isInteger(num2)) {
                        // l1 == null && l2 != null
                        if (top == 1) {
                            no = top + Integer.parseInt(num2);
                            list.add(no);
                        } else {
                            no = Integer.parseInt(num2);
                            list.add(no);
                        }
                    }
                }
            }

        } catch (NullPointerException e) {

        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i));
            // if (i==0) {
            // result = new ListNode(list.get(i));
            // } else {
            // result.next = new ListNode(list.get(i));
            // }
            if (i != 0) {
                result.next = new ListNode(list.get(i));
            } else {
                result = new ListNode(list.get(i));
            }
        }
        return result;
    }

    public static ListNode addList(ListNode ln, int i, int no) {

        if (i != 0) {
            ln = ln.next;
            ln = new ListNode(no);
        } else {
            ln = new ListNode(no);
        }
        System.out.println("after is : " + ln.val);
        return ln;
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
