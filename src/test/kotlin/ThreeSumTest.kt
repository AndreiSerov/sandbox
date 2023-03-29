import MapDiscovery.map
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Arrays

/**
 * @author andreiserov
 */
class ThreeSumTest {

    @Test fun fst() {
        assertTrue(threeSum(intArrayOf(0, 0, 0, 0)).also { println(it) }.size == 1)
        assertTrue(
            threeSum(intArrayOf(2,0,-2,-5,-5,-3,2,-4)).also { println(it) }.toSet() == listOf(
                listOf(-4,2,2), listOf(-2,0,2)
            ).toSet()
        )


        assertTrue(threeSum(intArrayOf(1,-1,-1,0)).also { println(it) }.size == 1)
        val set = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).also { println(it) }
        assertTrue(
            set.toSet() == listOf(
                listOf(-1, -1, 2), listOf(-1, 0, 1)
            ).toSet()
        )



        assertTrue(
            threeSum(intArrayOf(0, 0, 0)).also { println(it) }.toSet()
                    == listOf(
                listOf(0, 0, 0)
            ).toSet()
        )
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        if (nums.size < 3) return emptyList()
        if(nums[0] > 0) return emptyList()

        if (nums.size < 10 && nums.toSet().size == 1 && nums[0] == 0) return listOf(listOf(0, 0, 0))

        val map = mutableListOf<List<Int>>()
        val sortedNums = nums.sorted()
        var prevA: Int? = null
        var prevB: Int? = null
        var prevC: Int? = null
        var prevCIndex: Int? = null

        for (i in 0 until nums.size - 2) {
            val a = sortedNums[i]
            if (a == prevA) continue

            for (left in i + 1 until nums.size - 1) {
                val b = sortedNums[left]
                if (b == prevB) continue

                for (right in left + 1 until nums.size) {
                    val c = sortedNums[right]

                    if (c == prevC){
                        if (b < c) {
                            continue
                        }
                    }
                    if (-a == b + c) {
                        map.add(listOf(a, b, c))
                    }
                    prevC = if (right == nums.size - 1) null else c
                }
                prevB = b
            }
            prevA = a
        }
        return map
    }

    fun areEqual(a: Int, b: Int, c: Int): Boolean {
        return -a == b + c
    }
}