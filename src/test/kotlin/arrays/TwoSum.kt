package arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class TwoSum {
    @Test fun test1() {

        // todo create
        assertEquals(intArrayOf(0, 1), twoSum(intArrayOf(2,7,11,15), 9))
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>() // index

        nums.forEachIndexed { index, num ->
            val diff = target - num
            if (map.contains(diff)) return intArrayOf(map[diff]!!, index)
            if (!map.contains(num)) {
                map[num] = index
            }
        }

        return intArrayOf()
    }
}