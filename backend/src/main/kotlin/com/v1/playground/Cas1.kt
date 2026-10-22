package com.v1.playground

fun main() {
    println("Hello World!")
    collections()


}

fun valVar() {
    val a = 0
    var b = 1
    println("Vrednost $a")
}

fun nullSafety() {
    val rec: String? = null
}

fun whenIf() {
    val a = 5
    val b = if (a == 5) 0 else 5

    val boja: Boja = Boja.BLUE

    when (boja) {
        Boja.BLUE -> println("BLUE")
        Boja.GREEN -> println("GREEN")
        Boja.RED -> println("RED")
        Boja.PURPLE -> TODO()
    }

}

data class Car(
    val brand: String,
    val model: String,
    val price: Int
)

fun collections(){
    val labels  = mutableListOf<Int>()
    labels.add(0)

    val labels2 = listOf("A", "B", "C")

    val numbers = listOf(1,2,3,4,5,6,7)

    println(numbers.filter { it % 2 == 0 })

}

