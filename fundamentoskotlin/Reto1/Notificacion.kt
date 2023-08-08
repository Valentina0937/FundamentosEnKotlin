package com.Valentina0937.fundamentoskotlin.Reto1

class Notificacion {
}

fun main() {
    var phones: MutableList<Int> = mutableListOf()
    println("Bienvenido al sistema")
    println("¿cual ese el mensaje de las notificaciones que recibiste?")
    var menssage = readln().lowercase()
    println("Cuantos telefonos")
    var cant= readln()!!.toInt()
    for (i in 1..cant){
        println("cuantas notificaciones tendra el telefono $i")
        var phone:Int=readln().toInt()
        phones.add(phone)
    }

    for (i in phones.indices){
        if (phones[i]==0){
            println("El telefono ${i+1} no tienes notificaciones")
        }
        else if (phones[i]<100) {
            println("El telefono ${i+1} notificaciones: $menssage ${phones[i]} ")
        }
        else if(phones[i]>=100){
            println("El telefono ${i+1} notificaciones: $menssage 99+")
        }
        else{
            println("Error")
        }
    }
}