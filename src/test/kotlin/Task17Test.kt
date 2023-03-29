//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//import java.awt.Image
//import java.util.*
//import java.util.stream.Collectors
//
///**
// * @author andreiserov
// */
//internal class Task17Test {
//
//
//    @Test fun test1() {
//        assertEquals(listOf("ad","ae","af","bd","be","bf","cd","ce","cf"), letterCombinations("23"))
//    }
//
//    @Test fun test2() {
//        assertEquals(listOf<String>(), letterCombinations(""))
//    }
//
//    @Test fun test3() {
//        assertEquals(listOf("a","b","c"), letterCombinations("2"))
//    }
//
//    @Test fun test4() {
//        val expected = listOf("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg",
//            "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg",
//            "ceh", "cei", "cfg", "cfh", "cfi"
//        ) // size = 27
//
//        assertEquals(
//            expected,
//            letterCombinations("234")
//        )
//    }
//
//    @Test fun test5() {
//        val expected = listOf(
//            "adgj", "adgk", "adgl", "adhj", "adhk", "adhl", "adij", "adik", "adil", "aegj",
//            "aegk", "aegl", "aehj", "aehk", "aehl", "aeij", "aeik", "aeil", "afgj", "afgk", "afgl",
//            "afhj", "afhk", "afhl", "afij", "afik", "afil", "bdgj", "bdgk", "bdgl", "bdhj", "bdhk", "bdhl",
//            "bdij", "bdik", "bdil", "begj", "begk", "begl", "behj", "behk", "behl", "beij", "beik", "beil",
//            "bfgj", "bfgk", "bfgl", "bfhj", "bfhk", "bfhl", "bfij", "bfik", "bfil", "cdgj", "cdgk", "cdgl",
//            "cdhj", "cdhk", "cdhl", "cdij", "cdik", "cdil", "cegj", "cegk", "cegl", "cehj", "cehk", "cehl",
//            "ceij", "ceik", "ceil", "cfgj", "cfgk", "cfgl", "cfhj", "cfhk", "cfhl", "cfij", "cfik", "cfil"
//        ) // size = 81
//
//        assertEquals(
//            expected,
//            letterCombinations("2345")
//        )
//    }
//
//    @Test fun test6() {
//        val expected = listOf(
//            "adgp", "adgq", "adgr", "adgs", "adhp", "adhq", "adhr", "adhs", "adip", "adiq", "adir", "adis", "aegp", "aegq", "aegr", "aegs", "aehp",
//            "aehq", "aehr", "aehs", "aeip", "aeiq", "aeir", "aeis", "afgp", "afgq", "afgr", "afgs", "afhp", "afhq", "afhr", "afhs", "afip", "afiq",
//            "afir", "afis", // 36
//            "bdgp", "bdgq", "bdgr", "bdgs", "bdhp", "bdhq", "bdhr", "bdhs", "bdip", "bdiq", "bdir", "bdis", "begp", "begq", "begr", "begs", "behp",
//            "behq", "behr", "behs", "beip", "beiq", "beir", "beis", "bfgp", "bfgq", "bfgr", "bfgs", "bfhp", "bfhq", "bfhr", "bfhs", "bfip", "bfiq", "bfir",
//            "bfis", "cdgp", "cdgq", "cdgr", "cdgs", "cdhp", "cdhq", "cdhr", "cdhs", "cdip", "cdiq", "cdir", "cdis", "cegp", "cegq", "cegr", "cegs", "cehp",
//            "cehq", "cehr", "cehs", "ceip", "ceiq", "ceir", "ceis", "cfgp", "cfgq", "cfgr", "cfgs", "cfhp", "cfhq", "cfhr", "cfhs", "cfip", "cfiq", "cfir", "cfis"
//        ) // size = 108
//
//        assertEquals(
//            expected,
//            letterCombinations("2347")
//        )
//        println(letterCombinations("27")?.size)         // 12
//        println(letterCombinations("237")?.size)        // 36
//        println(letterCombinations("79")?.size)         // 16
//        println(letterCombinations("2347")?.size)       // 108
//    }
//
//    fun isAnagram(symbols: String, word: String): Boolean {
//        val coll =
//            ArrayList(Arrays.stream(symbols.split("".toRegex()).dropLastWhile { it.isEmpty() }
//                .toTypedArray())
//                .collect(Collectors.toList())
//            )
//        return try {
//            Arrays.stream(word.lowercase().split("".toRegex()).dropLastWhile { it.isEmpty() }
//                .toTypedArray())
//                .forEach { cur: String ->
//                    if (!coll.contains(cur)) throw Exception("kalia")
//                    coll.remove(cur)
//                }
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//}
//
