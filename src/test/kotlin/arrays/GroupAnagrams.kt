package arrays

import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class GroupAnagrams {
    @Test fun test1() {

    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        strs.forEach {str ->
            val arr = str.toCharArray()
            val sortedStr = arr.sorted().joinToString("")

            if (!map.contains(sortedStr)) {
                map[sortedStr] = mutableListOf(str)
            } else {
                map[sortedStr]!!.add(str)
            }
        }

        return map.values.toList()
    }
}