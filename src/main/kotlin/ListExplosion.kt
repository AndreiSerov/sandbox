
/**
 * @author andreiserov
 */

fun main() {
    var list = arrayListOf(1, 2, 3, 4, 5)


    for (i in list) {
        for (index in 0..list.size) {
            if (list[index] % 2 == 0) {
                list.remove(index)
            }
        }
    }
}