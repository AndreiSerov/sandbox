import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class ValidPalindrome {
    fun isPalindrome(str: String): Boolean {
        val s = str.replace("""[\W+_]""".toRegex(), "").toLowerCase()
        for (i in s.indices) {
            if (s[i] != s[s.length - 1 - i]) return false
        }
        return true
    }


    @Test fun test1() {
        assertFalse(isPalindrome("race a car"))
        assertTrue(isPalindrome("ab_a"))
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }
}