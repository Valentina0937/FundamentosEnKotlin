package com.Valentina0937.fundamentoskotlin.Reto4

class Restaurant {
}
fun main() {
    var menu=mutableMapOf<String, MutableList<Map<String, Any>>>(
        "entradas" to mutableListOf(),
        "platos fuertes" to mutableListOf(),
        "postres" to mutableListOf(),
        "bebidas" to mutableListOf()
    )
    println("Bienvenido al restaurante")
    println("Por favor ingrese la función qu desea realizar\n1.Agregar plato" +
            "\n2.Mostrar todos los platos\n3.Mostrar platos por código\n4.Modificar menú" +
            "\n5.Modificar plato\n6.Eliminar un plato")
    var opcion= readln()!!.toInt()
    when(opcion) {
        1 -> {
            println(
                "Ingrese la categoría del plato\n1.Entradas\n2.Platos fuertes" +
                        "\n3.Postres\n4.Bebidas"
            )
            var opcion2 = readln()!!.toInt()
            if (opcion == 1 || opcion==2 || opcion==3 || opcion==4) {
                var cate = readln().toString().lowercase()
                println("Ingrese el nombre del plato")
                var name = readln().toString().lowercase()
                println("Ingrese la descripción del plato")
                var descrip = readln().toString().lowercase()
                println("Ingrese el precio del plato")
                var price = readln()!!.toInt()
                if (name != null && descrip != null && price != null) {
                    val nuevoPlato = mapOf("nombre" to name, "descripcion" to descrip, "precio" to price)
                    menu[cate]?.add(nuevoPlato)
                }
            }
        }

        2 -> {
            println("Menú")
            for ((categoria, platos) in menu) {
                println("\n$categoria")
                for ((indice, plato) in platos.withIndex()) {
                    println("Código ${indice + 1}: ${plato["nombre"]}, ${plato["descripcion"]}, Precio: $${plato["precio"]}")
                }
            }
        }
        3->{
            println("Ingrese la categoría del plato:")
            val categoria = readLine()?.trim()?.lowercase()
            if (menu.containsKey(categoria)) {
                println("Ingrese el código del plato:")
                val codigo = readLine()?.toIntOrNull()
                if (codigo != null && codigo >= 1 && codigo <= menu[categoria]?.size ?: 0) {
                    val plato = menu[categoria]?.get(codigo - 1)
                    println("Plato seleccionado: ${plato?.get("nombre")}, ${plato?.get("descripcion")}, Precio: $${plato?.get("precio")}")
                } else {
                    println("Código de plato inválido.")
                }
            } else {
                println("Categoría inválida.")
            }
        }
        4 -> {
            println("Ingrese el nombre de la nueva categoría:")
            val nuevaCategoria = readLine()?.trim()?.lowercase() ?: ""
            if (!menu.containsKey(nuevaCategoria)) {
                menu[nuevaCategoria] = mutableListOf()
                println("Categoría agregada al menú.")
            } else {
                println("La categoría ya existe en el menú.")
            }
        }


        5 -> {
            println("Ingrese la categoría del plato a modificar:")
            val categoria = readLine()?.trim()?.lowercase()
            if (menu.containsKey(categoria)) {
                println("Ingrese el código del plato a modificar:")
                val codigo = readLine()?.toIntOrNull()
                if (codigo != null && codigo >= 1 && codigo <= menu[categoria]?.size ?: 0) {
                    val platoModificado = menu[categoria]?.get(codigo - 1)?.toMutableMap()

                    println("Ingrese el nuevo nombre del plato:")
                    val nuevoNombre = readLine()?.trim()
                    platoModificado?.put("nombre", nuevoNombre ?: "")

                    println("Ingrese la nueva descripción del plato:")
                    val nuevaDescripcion = readLine()?.trim()
                    platoModificado?.put("descripcion", nuevaDescripcion ?: "")

                    println("Ingrese el nuevo precio del plato:")
                    val nuevoPrecio = readLine()?.toDoubleOrNull()
                    platoModificado?.put("precio", nuevoPrecio ?: 0.0)

                    if (platoModificado != null) {
                        menu[categoria]?.set(codigo - 1, platoModificado)
                        println("Plato modificado con éxito.")
                    }
                } else {
                    println("Código de plato inválido.")
                }
            } else {
                println("Categoría inválida.")
            }
        }
        6 -> {
            println("Ingrese la categoría del plato a eliminar:")
            val categoria = readLine()?.trim()?.lowercase()
            if (menu.containsKey(categoria)) {
                println("Ingrese el código del plato a eliminar:")
                val codigo = readLine()?.toIntOrNull()
                if (codigo != null && codigo >= 1 && codigo <= menu[categoria]?.size ?: 0) {
                    val platoEliminado = menu[categoria]?.removeAt(codigo - 1)
                    if (platoEliminado != null) {
                        println("Plato eliminado del menú.")
                    }
                } else {
                    println("Código de plato inválido.")
                }
            } else {
                println("Categoría inválida.")
            }
        }
        7-> {
            println("Gracias por utilizar nuestro programa")
            return
        }
    }
    }


