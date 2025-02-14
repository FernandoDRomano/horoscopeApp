// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    // LIBRERIA PARA INYECCION DE DEPENDENCIAS
    id("com.google.dagger.hilt.android") version "2.48" apply false

    //LIBRERIA PARA NAVEGACION SEGURA ENTRE VISTAS (FRAGMENT -> ACTIVITY)
    id("androidx.navigation.safeargs.kotlin") version "2.7.1" apply false
}