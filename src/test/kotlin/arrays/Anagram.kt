package arrays

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class Anagram {
    @Test fun test1() {
        assertTrue(isAnagram( "nagaram", "anagram"))
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = mutableMapOf<Char, Int>()
        s.forEach {
            if (map.keys.contains(it)) {
                map[it] = map[it]!! + 1
            } else {
                map[it] = 1
            }
        }
        t.forEach {
            if (!map.keys.contains(it) || map[it] == 0) return false

            map[it] = map[it]!! - 1
        }
        return map.values.sum() == 0
    }
}