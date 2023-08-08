package com.Valentina0937.fundamentoskotlin.Reto5

class Nequi {
}
fun main() {
    val clave1=1234
    val num: Long =3123456789
    var saldo:Int=4500
    var retiro=0
    var enviar=0
    var recarga=0
    var i=3
    var respuesta=""

    while(i>0){
        println("Bienvendo a la aplicación Nequi Colombia")
        println("Por favor ingrese el telefono")
        var telefono= readLine()!!.toLong()
        println("Por favor ingrese la clave")
        var clave=readLine()!!.toInt()
        if(clave1 == clave && num.toLong() == telefono) {
            i = 0
            do {
                println("Has ingresado al sistema")
                println("Su saldo es: $saldo")
                println("¿Qué función desea realizar?\n1.Retirar\n2.Enviar\n3.Recargar\n4.Salir")
                var opcion = readln()!!.toInt()
                if (opcion == 1) {
                    println("Elija una opcioón\n1.Cajero\n2.Punto físico")
                    var opcion2 = readLine()!!.toInt()
                    if ((opcion2 == 1 || opcion2 == 2) && saldo > 2000) {
                        println("¿Cuánto desea retirar?")
                        retiro = readln()!!.toInt()
                        saldo = saldo - retiro
                        println("Su código es 5435")
                        println("¿Desea volver al menú?")
                        respuesta = readln().toString().lowercase()
                    }
                } else if (opcion == 2) {
                    println("Por favor ingrese el número al cual desea enviar el dinero")
                    var telefono2 = readLine()!!.toLong()
                    println("Ingrese el valor que desea enviar")
                    enviar = readLine()!!.toInt()
                    if (enviar > saldo) {
                        println("No es posible enviar el dinero, su saldo es:${saldo}")
                    } else {
                        println("Proceso realizado con éxito")
                        saldo = saldo - enviar
                        println("¿Desea volver al menú?")
                        respuesta = readln().toString().lowercase()
                    }
                } else if (opcion == 3) {
                    println("Ingrese el valor a recargar")
                    recarga = readLine()!!.toInt()
                    println("¿Seguro que desea realizar una recarga del valor ${recarga}?")
                    var resp = readLine().toString().lowercase()
                    if (resp == "si") {
                        println("Recarga realizada con éxito")
                        saldo = saldo + recarga
                        println("¿Desea volver al menú?")
                        respuesta = readln().toString().lowercase()
                    }
                    else{
                        println("Proceso rechazado")
                        println("¿Desea volver al menú?")
                        respuesta = readln().toString().lowercase()
                    }

                } else if (opcion == 4) {
                    println("Gracias por utilizar nuestra aplicación Nequi Colombia")
                    return
                }
            }while (respuesta=="si")
        }
        else {
            println("¡Upps! Parece que tus datos de acceso no son correctos, Tienes ${i} intentos más")
            i--
        }

    }
}