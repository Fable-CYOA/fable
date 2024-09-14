plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
                implementation(project(":worldstate"))
            }
        }
    }
}