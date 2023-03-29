import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class SingleLinkedList {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false

        var fast = head
        var slow: ListNode? = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next

            if (fast == slow) return true
        }

        return false
    }

    @Test fun linkedListCycle() {
        val elem4 = ListNode(-4, )
        val elem3 = ListNode(0, elem4)
        val elem1 = ListNode(2, elem3)
        val head = ListNode(3, elem1)
        elem4.next = elem1

        assertTrue(hasCycle(head))
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? = if (list1 == null) list2
    else if (list2 == null) list1
    else if (list1.`val`!! <= list2.`val`!!) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    }
    else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }



    @Test fun linkedListMerge() {
        val lst1 = ListNode(1, ListNode(2, ListNode(4)))
        val lst2 = ListNode(1, ListNode(3, ListNode(4)))

        val expected = ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4))))))


        val actual = mergeTwoLists(lst1, lst2)
        assertEquals(expected, actual)
    }

}

data class ListNode(
    var `val`: Int?,
    var next: ListNode? = null
)