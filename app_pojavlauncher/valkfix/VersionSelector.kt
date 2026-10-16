package valkfix

enum class ValkFixModule {
    VS_2_4_0,
    VS_2_4_1_1,
    UNSUPPORTED
}

object VersionSelector {

    fun detect(version: String): ValkFixModule {
        return when (version.trim()) {
            "2.4.0" -> ValkFixModule.VS_2_4_0
            "2.4.1.1" -> ValkFixModule.VS_2_4_1_1
            else -> ValkFixModule.UNSUPPORTED
        }
    }
}
