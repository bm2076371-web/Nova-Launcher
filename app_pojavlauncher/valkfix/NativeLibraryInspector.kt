
package valkfix

import java.util.zip.ZipFile

object NativeLibraryInspector {

    private const val ARM64_LIBRARY =
        "libKrunchJniarm64.so"

    fun inspect(jarPath: String): String {
        return try {
            ZipFile(jarPath).use { jar ->
                val hasArm64 = jar.entries().asSequence()
                    .any { it.name.endsWith(ARM64_LIBRARY) }

                if (hasArm64) {
                    "ARM64_LIBRARY_FOUND"
                } else {
                    "ARM64_LIBRARY_MISSING"
                }
            }
        } catch (e: Exception) {
            "JAR_READ_ERROR: ${e.javaClass.simpleName}"
        }
    }
}
