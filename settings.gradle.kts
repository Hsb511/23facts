pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "facts23"

include(":app")
include(":fact")
include(":home")
include(":room")
include(":settings")
include(":core")
include(":achievements")
include(":search")
include(":domain")
