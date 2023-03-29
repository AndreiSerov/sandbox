//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
///**
// * @author andreiserov
// */
//class GroupAnagrams {
//
//    @Test fun test1() {
//        assertEquals(
//            listOf(
//                listOf("bat"),
//                listOf("nat", "tan"),
//                listOf("ate", "eat", "tea")
//            ),
//            groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")).sortedBy { it.size }
//        )
//
//    }
//
//    fun groupAnagrams(strs: Array<String>): List<List<String>> {
//        val map = mutableMapOf<String, List<String>>()
//        strs.forEach {
////            val alphabetString = it.toCharArray().sortedArray().contentToString()
//            map[alphabetString] = listOf(it) + (map[alphabetString] ?: emptyList())
//        }
//
//        return map.values.toList()
//    }
//}