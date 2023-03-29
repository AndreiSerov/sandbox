//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//
///**
// * @author andreiserov
// */
//class SpiralMatrix {
//    fun spiralOrder1(matrix: Array<IntArray>): List<Int> {
//        if (matrix.isEmpty()) return emptyList()
//
//        val m = matrix.size
//        val n = matrix.first().size
//
//        var right = n - 1
//        var bottom = m - 1
//        var top = 0
//        var left = 0
//
//        val result = mutableListOf<Int>()
//
//        var index1 = 0
//        var index2 = 0
//
//        for (i in 0 until m) {
//            for (j in 0 until n) {
//                result.add(matrix[index1][index2])
//
//                if (index2 < right && index1 == top) {
//                    if (index2 + 1 == right && m != 2) top++
//                    index2++
//                } else if (index1 < bottom && index2 == right) {
//                    if (index1 + 1 == bottom) right--
//                    index1++
//                } else if (index2 > left && index1 == bottom) {
//                    if (index2 - 1 == left) bottom--
//                    index2--
//                } else if (index1 > top && index2 == left) {
//                    if (index1 - 1 == top) left++
//                    index1--
//                }
//            }
//        }
//
//        return result
//    }
//
//    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        val res: MutableList<Int> = ArrayList()
//        if (matrix.isEmpty()) {
//            return res
//        }
//        var rowStart = 0
//        var rowEnd = matrix.size - 1
//        var colStart = 0
//        var colEnd = matrix[0].size - 1
//        var direction = 0
//        while (rowStart <= rowEnd && colStart <= colEnd) {
//            when (direction) {
//                0 -> {
//                    var j = colStart
//                    while (j <= colEnd) {
//                        //Right
//                        res.add(matrix[rowStart][j])
//                        j++
//                    }
//                    rowStart++
//                }
//
//                1 -> {
//                    var j = rowStart
//                    while (j <= rowEnd) {
//                        res.add(matrix[j][colEnd])
//                        j++
//                    }
//                    colEnd--
//                }
//
//                2 -> {
//                    var j = colEnd
//                    while (j >= colStart) {
//                        //Left
//                        res.add(matrix[rowEnd][j])
//                        j--
//                    }
//                    rowEnd--
//                }
//
//                3 -> {
//                    var j = rowEnd
//                    while (j >= rowStart) {
//                        //up
//                        res.add(matrix[j][colStart])
//                        j--
//                    }
//                    colStart++
//                }
//            }
//            direction = (direction + 1) % 4
//        }
//        return res
//    }
//
//    var matrix = arrayOf(
//        intArrayOf(1, 2), intArrayOf(3, 4)
//    )
//    var expected = listOf(1, 2, 4, 3)
//
//    @Test fun test1() {
//        assertEquals(expected, spiralOrder(matrix))
//
//    }
//
//    @Test fun test21() {
//        matrix = arrayOf(
//            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
//            intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
//        )
//
//        expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11)
//
//        assertEquals(expected, spiralOrder(matrix))
//    }
//
//    @Test fun test2() {
//        matrix = arrayOf(
//            intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
//        )
//
//        expected = listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
//
//        assertEquals(expected, spiralOrder(matrix))
//    }
//
//    @Test fun test22() {
//        matrix = arrayOf(
//            intArrayOf(1, 5),
//            intArrayOf(2, 6),
//            intArrayOf(3, 7),
//            intArrayOf(4, 8),
//
//            )
//
//        expected = listOf(1, 5, 6, 7, 8, 4, 3, 2)
//
//        assertEquals(expected, spiralOrder(matrix))
//    }
//
//    @Test fun test3() {
//        matrix = arrayOf(
//            intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12)
//        )
//
//        expected = listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
//
//        assertEquals(expected, spiralOrder(matrix))
//    }
//
//    @Test fun test4() {
//        matrix = arrayOf(
//            intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16)
//        )
//
//        expected = listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
//
//        assertEquals(expected, Solution().spiralOrder(matrix))
//    }
//
//    fun hammingWeight(n:Int):Int {
//        var count = 0
//        var a = 1
////        for (i in 0..31) {
//            if (n and a !== 0) count++
//            a = a shl 1
//        }
//        return count
//    }
//
//    @Test fun test5() {
//
//        val n = 1011
//
//        assertEquals(3, hammingWeight(n))
//    }
//
//
//}
//
//class Solution {
//    private lateinit var visited: Array<BooleanArray>
//    private val x = intArrayOf(0, 1, 0, -1)
//    private val y = intArrayOf(1, 0, -1, 0)
//    private lateinit var matrix: Array<IntArray>
//
//
//    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        visited = Array(matrix.size) { BooleanArray(matrix.first().size) }
//        this.matrix = matrix
//
//        val result = mutableListOf<Int>()
//        spiral(0, 0, 0, result)
//
//        return result
//    }
//
//    private fun spiral(i: Int, j: Int, _c: Int, result: MutableList<Int>) {
//        var c = _c
//
//        result.add(matrix[i][j])
//        visited[i][j] = true
//
//        if (checkValid(i, j, c)) {
//            c++
//            if (c > x.size - 1) c = 0
//        }
//        if (checkValid(i, j, c)) return
//        spiral(i + x[c], j + y[c], c, result)
//    }
//
//    private fun checkValid(i: Int, j: Int, c: Int) =
//        (i + x[c] > matrix.size - 1 || i + x[c] < 0 || j + y[c] > matrix[0].size - 1 || j + y[c] < 0 || visited[i + x[c]][j + y[c]])
//}
//
