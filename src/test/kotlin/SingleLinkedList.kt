import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class SingleLinkedList {
    fun hasCycle(head: ListNodeO?): Boolean {
        if (head == null) return false

        var fast = head
        var slow: ListNodeO? = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next

            if (fast == slow) return true
        }

        return false
    }

    fun detectCycle(head: ListNodeO?): ListNodeO? {
        if (head == null) return null

        var fast = head
        var slow: ListNodeO? = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next

            if (fast == slow) return getCycledNode(head, fast)
//            {
//                slow = head
//                while (slow != fast) {
//                    slow = slow?.next
//                    fast = fast?.next
//                }
//                return slow
//            }
        }

        return null
    }

    private fun getCycledNode(head: ListNodeO?, _fast: ListNodeO?): ListNodeO? {
        var slow = head
        var fast = _fast
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }

    @Test fun linkedListdetectCycle() {
        val elem4 = ListNodeO(-4, )
        val elem3 = ListNodeO(0, elem4)
        val elem1 = ListNodeO(2, elem3)
        val head = ListNodeO(3, elem1)
        elem4.next = elem1

        assertTrue(detectCycle(head) == elem1)
    }

    @Test fun linkedListCycle() {
        val elem4 = ListNodeO(-4, )
        val elem3 = ListNodeO(0, elem4)
        val elem1 = ListNodeO(2, elem3)
        val head = ListNodeO(3, elem1)
        elem4.next = elem1

        assertTrue(hasCycle(head))
    }

    fun mergeTwoLists(list1: ListNodeO?, list2: ListNodeO?): ListNodeO? = if (list1 == null) list2
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
        val lst1 = ListNodeO(1, ListNodeO(2, ListNodeO(4)))
        val lst2 = ListNodeO(1, ListNodeO(3, ListNodeO(4)))

        val expected = ListNodeO(1, ListNodeO(1, ListNodeO(2, ListNodeO(3, ListNodeO(4, ListNodeO(4))))))


        val actual = mergeTwoLists(lst1, lst2)
        assertEquals(expected, actual)
    }

}

data class ListNodeO(
    var `val`: Int?,
    var next: ListNodeO? = null
) {
    override fun toString(): String {
        return "ListNode{val=$`val`}"
    }
}