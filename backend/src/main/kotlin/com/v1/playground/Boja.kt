package com.v1.playground

sealed class Boja {
    data object RED : Boja()
    data object GREEN : Boja()
    data object BLUE : Boja()
    data object PURPLE : Boja()
}