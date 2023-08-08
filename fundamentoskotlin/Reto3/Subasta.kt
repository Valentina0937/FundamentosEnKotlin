package com.Valentina0937.fundamentoskotlin.Reto3
class Subasta {

}
fun main() {
    val articulos = mutableListOf<Pair<String, Double>>()

    println("¡Bienvenido a la subasta!")
    println("¿Cuántos artículos desea subastar?")
    val cant = readLine()!!.toInt()

    for (i in 1..cant) {
        println("Ingrese el nombre del artículo $i:")
        val name = readLine().toString()
        println("Ingrese el precio base del artículo $i:")
        val precioBase = readLine()!!.toDouble()
        articulos.add(name to precioBase)
    }

    println("Empecemos la subasta")
    for ((name, precioBase) in articulos) {
        println("Subastando $name Precio base: $precioBase)")
        println("¿Cuántas ofertas tiene para $name?")
        val cant2 = readLine()!!.toInt()
        var ofertaAlta = precioBase
        var ganador =""

        for (i in 1..cant2) {
            println("Oferta $i:")
            print("Nombre del Ofertante $i: ")
            val ofertante = readLine().toString()
            print("Monto de la oferta: ")
            val montoOferta = readLine()?.toDoubleOrNull() ?: 0.0
            if (montoOferta > ofertaAlta) {
                ofertaAlta = montoOferta
                ganador = ofertante
                println("Oferta exitosa: $ofertante ofrece $montoOferta")
            } else {
                println("La oferta no supera el precio más alto.")
            }
        }
        if (ganador != null) {
            println("¡$ganador ganó $name por $ofertaAlta!")
        } else {
            println("¡$name no recibió ofertas y se vendió a la casa de subastas por $precioBase!")
        }
    }
}

