package arrays

import java.util.stream.Collectors.toList

/**
 * @author andreiserov
 */
class TopKFrequent {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            if (map.contains(it)) {
                map[it] = map[it]!! + 1
            } else {
                map[it] = 1
            }
        }
        return map
            .toList()
            .asSequence()
            .sortedByDescending { (_, value) -> value}
            .take(k)
            .toMap()
            .keys
            .toIntArray()
    }
}