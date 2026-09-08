pluginManagement {
    repositories {
<<<<<<< HEAD
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
=======
        google()
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
        mavenCentral()
        gradlePluginPortal()
    }
}
<<<<<<< HEAD
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
=======
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "EX-6 PMD"
=======
rootProject.name = "runtimepermission"
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
include(":app")
 