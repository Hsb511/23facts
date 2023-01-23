object AppVersions {
    private const val prodVersion = 1
    private const val stagingVersion = 0
    private const val debugVersion = 2

    const val versionName = "$prodVersion.$stagingVersion.$debugVersion"
    const val versionCode = prodVersion * 1_000_000 + stagingVersion * 1_000 + debugVersion
}
