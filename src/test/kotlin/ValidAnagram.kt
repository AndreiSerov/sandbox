import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class ValidAnagram {

    @Test fun test1() {
        assertTrue(
            isAnagram("anagram", "nagaram")
        )

        assertFalse(
            isAnagram("rat", "car")
        )
    }

    fun isAnagram(symbols: String, word: String): Boolean {
        if (symbols.length != word.length) return false

        val symolsArr = symbols.toCharArray().sortedArray()
        val wordArr = word.toCharArray().sortedArray()

        return symolsArr.contentEquals(wordArr)
    }
}