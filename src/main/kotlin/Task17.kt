/**
 * @author andreiserov
 */

/**
 * Given a string containing digits from 2-9 inclusive, return all
 * possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
private val map = mapOf(
    2 to "abc",
    3 to "def",
    4 to "ghi",
    5 to "jkl",
    6 to "mno",
    7 to "pqrs",
    8 to "tuv",
    9 to "wxyz"
)




// 3
// 3 ** 3
//
fun printStrings(
    phNo: String,
    i: Int,
    hm: Map<Int, String>,
    str: StringBuilder
) {
    // If all digits are processed, print output
    // string
    if (i == phNo.length) {
        print("$str ")
        return
    }

    // Get current digit of phNo, and recur for all
    // characters that can be used to dial it.
    val s = hm[phNo[i].code]
    for (j in 0 until s!!.length) {
        str.append(s[j])
        printStrings(phNo, i + 1, hm, str)
        str.deleteCharAt(str.length - 1)
    }
}

fun main() {
    printStrings("237", 0, map, java.lang.StringBuilder())
}

fun mapping(digits: String,
            index: Int,
            source: String
): MutableList<String>? {

    var list = mutableListOf<String>()

    if (index >= digits.length) {
        list.add(source)
        return null
    }

    val digit = digits[index]
    val nextStr = map[digit - '0'] ?: ""

    nextStr.forEach { letter ->
        mapping(digits, index+1, source+letter)
    }
    return list
}

fun letterCombinations(digits: String): MutableList<String>? {
//    if (digits.isEmpty()) return listOf()

    return mapping(digits, 0, "")
}


