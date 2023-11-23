package two_pointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class TwoSumSortedInput {
    @Test fun test1() {

        assertEquals(intArrayOf(0, 1), twoSum(intArrayOf(2,7,11,15), 9))
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var start = 0
        var end = nums.size - 1

        while (start < end) {
            val sum = nums[start] + nums[end]
            if (sum == target) return intArrayOf(start, end)
            if (sum < target) start++
            if (sum > target) end--
        }

        return intArrayOf()
    }
}