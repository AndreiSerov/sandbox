import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class MaximumProductSubarray {
    @Test fun test1() {
        val input = intArrayOf(-2,0,-1)
        assertEquals(0, maxProduct(input))
    }


    @Test fun test() {
        val input = intArrayOf(2,3,-2,4)
        assertEquals(6, maxProduct(input))
    }
}

fun maxProduct(nums: IntArray): Int {
    var result = 0
    if (nums.isEmpty()) return result
    if (nums.size == 1) return nums[0]

    for (i in nums.indices) {
        var product = 1
        for (j in i  until nums.size) {
            product *= nums[j]
            if (product > result) result = product
        }
    }

    return result
}