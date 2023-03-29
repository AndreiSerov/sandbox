import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

/**
 * @author andreiserov
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val parentheses = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )

        s.forEach {
            if (stack.isEmpty() || it in parentheses.keys) {
                stack.push(parentheses[it])
            } else if (stack.peek() == it) {
                stack.pop()
            } else return false
        }

        return stack.isEmpty()
    }

    @Test fun test1() {
        assertTrue(isValid("()"))
        assertTrue(isValid("()[]{}"))
        assertTrue(isValid("{[]}"))

        assertFalse(isValid("(]"))
        assertFalse(isValid("(]){}"))
    }

}

