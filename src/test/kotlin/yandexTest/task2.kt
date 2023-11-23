package yandexTest

/**
 * @author andreiserov
 */

val TERMINATED = "APPLICATION_TERMINATED"

fun main() {
    val res = calcCrash()

    println(res)
}

fun calcCrash(n: Int = readLine()!!.toInt()): Double {

    var launchCount = 0
    var succesCount = 0


    repeat(n) {
        val eventName = readLine()!!
        val uid = readLine()!!.toInt()

        if (eventName == "APPLICATION_FINISHED_LAUNCHING") {
            launchCount++
        } else if (eventName == TERMINATED) {
            succesCount++
        }
    }

    return (launchCount.toDouble() - succesCount) * 100 / launchCount
}
/*
3
APPLICATION_FINISHED_LAUNCHING
111
APPLICATION_TERMINATED
111
APPLICATION_FINISHED_LAUNCHING
111

6
APPLICATION_FINISHED_LAUNCHING
111
UI_SHOWN
111
APPLICATION_FINISHED_LAUNCHING
1337
APPLICATION_TERMINATED
1337
PUSH_RECIEVED
111
APPLICATION_TERMINATED
111
 */

fun calculateCrashFreeSessions(events: List<Pair<String, Int>>): Double {
    var sessionsCount = 0
    var crashedSessionsCount = 0
    var lastLaunchEventTime: Int? = null

    for ((eventName, uid) in events) {
        if (eventName == "APPLICATION_FINISHED_LAUNCHING") {
            // Если есть неоконченная сессия, то она крашнулась
            if (lastLaunchEventTime != null) {
                crashedSessionsCount++
            }
            lastLaunchEventTime = uid
        } else {
            // Если приложение было закрыто без запуска, то это крашнутая сессия
            if (lastLaunchEventTime == null) {
                crashedSessionsCount++
            } else {
                sessionsCount++
                if (uid != lastLaunchEventTime) {
                    crashedSessionsCount++
                }
                lastLaunchEventTime = null
            }
        }
    }

    // Если есть неоконченная сессия в конце, то она крашнулась
    if (lastLaunchEventTime != null) {
        crashedSessionsCount++
    }

    return if (sessionsCount == 0) {
        0.0
    } else {
        (1 - crashedSessionsCount.toDouble() / sessionsCount) * 100
    }
}