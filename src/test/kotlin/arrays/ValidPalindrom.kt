package arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class ValidPalindrom {

    @Test fun test1() {
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }
    fun isPalindrome(s: String): Boolean {

        val str = s.replace("""[\W_]+""".toRegex(), "").lowercase()
        var start = 0
        var end = str.length - 1

        while (start < end) {
            if (str[start] != str[end]) return false

            start++
            end--
        }
        return true
    }
}