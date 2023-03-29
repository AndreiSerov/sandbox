import org.assertj.core.api.Assertions.anyOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class LongestPalindromicStrings {

    @Test fun test1() {
        val bab = Condition<String>({ it == "bab" }, "bab")
        val aba = Condition<String>({ it == "aba" }, "aba")

        assertThat(longestPalindrome("babad")).`is`(anyOf(bab, aba))

        assertThat(longestPalindrome("abadab")).isEqualTo("badab")

        assertThat(longestPalindrome("cbbd")).isEqualTo("bb")

        assertThat(longestPalindrome("ac")).isEqualTo("a")

        assertThat(longestPalindrome("aacabdkacaa")).isEqualTo("aca")
    }

    fun longestPalindrome(s: String): String {
        if (s == s.reversed()) return s
        val set = mutableSetOf<String>()

        s.forEach {
            val newSubstrs = set.mapNotNull {
                    substr -> (substr + it).let {
                    candidate -> if (s.contains(candidate)) candidate else null }
            }
            set.addAll(newSubstrs)
            set.add(it.toString())
        }

        return set.sortedByDescending { it.length }.first { it == it.reversed() }
    }
}