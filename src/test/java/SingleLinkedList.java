//import lombok.val;
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test
//
///**
// * @author andreiserov
// */
//class SingleLinkedList {
//    public boolean hasCycle(ListNodeO head) {
//        if (head == null) return false;
//
//        var fast = head;
//        var slow = head;
//
//        while (fast.next != null) {
//            fast = fast.next?.next
//            slow = slow?.next
//
//            if (fast == slow) return true
//        }
//
//        return false
//    }
//
//    fun detectCycle(head:ListNodeO?): ListNodeO? {
//        if (head == null) return null
//
//        var fast = head
//        var slow: ListNodeO ? = head
//
//        while (fast?.next != null) {
//            fast = fast.next?.next
//            slow = slow?.next
//
//            if (fast == slow) return getCycledNode(head, fast)
////            {
////                slow = head
////                while (slow != fast) {
////                    slow = slow?.next
////                    fast = fast?.next
////                }
////                return slow
////            }
//        }
//
//        return null
//    }
//
//    private fun getCycledNode(head:ListNodeO?, _fast:ListNodeO?): ListNodeO? {
//        var slow = head
//        var fast = _fast
//        while (slow != fast) {
//            slow = slow?.next
//            fast = fast?.next
//        }
//        return slow
//    }
//
//    @Test fun linkedListdetectCycle() {
//        val elem4 = ListNode(-4, )
//        val elem3 = ListNode(0, elem4)
//        val elem1 = ListNode(2, elem3)
//        val head = ListNode(3, elem1)
//        elem4.next = elem1
//
//        assertTrue(detectCycle(head) == elem1)
//    }
//
//    @Test fun linkedListCycle() {
//        val elem4 = ListNode(-4, )
//        val elem3 = ListNode(0, elem4)
//        val elem1 = ListNode(2, elem3)
//        val head = ListNode(3, elem1)
//        elem4.next = elem1
//
//        assertTrue(hasCycle(head))
//    }
//
//    fun mergeTwoLists(list1:ListNodeO?, list2:ListNodeO?): ListNodeO? = if (list1 == null) list2
//    else if (list2 == null) list1
//    else if (list1.`val`!! <= list2.`val`!!) {
//        list1.next = mergeTwoLists(list1.next, list2)
//        list1
//    }
//    else {
//        list2.next = mergeTwoLists(list1, list2.next)
//        list2
//    }
//
//
//
//    @Test fun linkedListMerge() {
//        val lst1 = ListNode(1, ListNode(2, ListNode(4)))
//        val lst2 = ListNode(1, ListNode(3, ListNode(4)))
//
//        val expected = ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4))))))
//
//
//        val actual = mergeTwoLists(lst1, lst2)
//        assertEquals(expected, actual)
//    }
//
//}
//
//class Main {
//    public static void yandexTest.main(String[] args) {
//        System.out.println("Hello world!");
//
//        final ListNode head = new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(4, null))
//                ));
//    }
//
//    public ListNode reverseList(ListNode head) {
//
//    }
//}
//
//// [1, 2, 3, 4] -> [4, 3, 2, 1]
//
//record  ListNode(
//        Integer val,
//        ListNode next
//) {
//}


class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        final ListNode head4 = new ListNode(4, null);
        final ListNode head3 = new ListNode(3, head4);
        final ListNode head2 = new ListNode(2, head3);
        final ListNode head1 = new ListNode(1, head2);
        final ListNode  example = head1;
// 1, 2, 3, 4 ->
        final ListNode result = reverseList(head1);
        System.out.println("stop here");


    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}

// [1, 2, 3, 4] -> [4, 3, 2, 1]

class ListNode {
    Integer val;
    ListNode next;

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}