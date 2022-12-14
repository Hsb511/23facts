object AppVersions {
    private const val prodVersion = 0
    private const val stagingVersion = 0
    private const val debugVersion = 3

    const val versionName = "$prodVersion.$stagingVersion.$debugVersion"
    const val versionCode = prodVersion * 1_000_000 + stagingVersion * 1_000 + debugVersion
}