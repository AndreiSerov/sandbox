package arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class ContainsDuplicate {
    @Test fun test1() {
        assertEquals(true, containsDuplicate(arrayOf(1,1,1,3,3,4,3,2,4,2)))
    }

    fun containsDuplicate(arr: Array<Int>): Boolean {
        val numbers = mutableSetOf<Int>()
        arr.forEach {
            if (numbers.contains(it)) return true
            numbers.add(it)
        }
        return false
    }
}