import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

/**
 * @author andreiserov
 */
class SameTree {
    val tree = TreeNode(1).apply {
        left = TreeNode(2).apply {
                left = TreeNode(5)
                right = TreeNode(6)
            }
        right = TreeNode(3)
    }

    val tree2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
                left = TreeNode(5)
                right = TreeNode(6)
            }
        right = TreeNode(3)
    }

    @Test fun test1() {

//        assertTrue(
//            isSameTree(tree2, tree)
//        )

        val tn = TreeNode(1).apply { left = TreeNode(2) }
        val tn2 =  TreeNode(1).apply { right = TreeNode(2) }

        assertFalse(isSameTree(tn, tn2))

        assertFalse(
            isSameTree(tree2, tree.apply {
                left = TreeNode(2).apply {
                        left = TreeNode(5)
                        right = TreeNode(8)
                    }
                right = TreeNode(3)
            })
        )
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return depthTraversal(p) == depthTraversal(q)
}

fun isSameTree1(p: TreeNode?, q: TreeNode?): Boolean = when {
    p == null && q == null -> true
    p != null && q != null -> p.`val` == q.`val` && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right)
    else -> false
}
private fun depthTraversal(tn: TreeNode?, res: MutableList<Int?> = mutableListOf()): MutableList<Int?> {

    if (tn != null) {
        res.add(tn.`val`)
        if (tn.left == null) {
            res.add(null)
        }
        depthTraversal(tn.left, res)
        if (tn.right == null) {
            res.add(null)
        }
        depthTraversal(tn.right, res)
    }
    return res
}

