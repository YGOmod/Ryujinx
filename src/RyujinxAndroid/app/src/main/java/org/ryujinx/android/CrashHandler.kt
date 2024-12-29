package org.ryujinx.android

import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.Thread.UncaughtExceptionHandler

class CrashHandler : UncaughtExceptionHandler {
    var crashLog: String = ""
    override fun uncaughtException(t: Thread, e: Throwable) {
        val sw = StringWriter()
        e.printStackTrace(PrintWriter(sw))
        val stackTrace = sw.toString()

        crashLog += "Thread: ${t.name}\nException: ${e.toString()}\nStackTrace:\n$stackTrace\n"

        File(MainActivity.AppPath + "${File.separator}Logs${File.separator}crash.log").writeText(
            crashLog
        )
    }
}