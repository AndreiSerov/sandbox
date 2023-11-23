package two_pointers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
class ContainerWithMostWater {
    @Test fun test1() {

        Assertions.assertEquals(49, maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }
    fun maxArea(height: IntArray): Int {


        return 0
    }
}