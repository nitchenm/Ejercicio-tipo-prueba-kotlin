package org.example

class GestorPedido {

    val menuComida: HashMap<Int, Producto> = HashMap()

    val carrito: ArrayList<Producto> = ArrayList()

    fun AnadirProducto (producto: Producto, posicion: Int){
        this.menuComida[posicion] = producto
    }

    fun MostrarMenu(){
        println("Catálogo disponible: ")
        for((key, producto ) in this.menuComida){
            when (producto) {
                is ProductoPrincipal -> {
                    val premium = if(producto.premium) "(Premium)" else ""
                    println("${key}. ${producto.nombre} - $${producto.precio} $premium")
                }
                is ProductoBebida -> {
                    println("${key}. ${producto.nombre} (${producto.tamano}) - $${producto.precio}")
                }
                else -> {
                        println("${key}. ${producto.nombre} - $${producto.precio}")
                }
            }
        }
    }

    fun AnadirAlCarrito(productos : String){
        val llavesString = productos.split(",")
        val llavesInt = llavesString.map { it.toInt() }
        val arrayInt = llavesInt.toIntArray()

        for (producto in this.menuComida){
            for (key in arrayInt){
                if (producto.key == key){
                    carrito.add(producto.value)
                }
            }
        }
    }

    fun MostrarCarrito(tipo: String ){
        var porcentaje = 0
        if (tipo == "regular"){
            porcentaje = 5
        }else if (tipo == "vip"){
            porcentaje = 10
        }else if (tipo == "premium"){
            porcentaje = 15
        }
        println("===RESUMEN DEL PEDIDO===")
        this.carrito.forEach { item -> println("- "+item.nombre + ": $" + item.precio) }
        var subtotal = 0.0
        this.carrito.forEach { item -> subtotal += item.precio}
        println("Subtotal: $${subtotal}")
        val descuento = (subtotal * porcentaje )/ 100
        println ("Descuento ${tipo.uppercase()} -${descuento.toString()}")
        var valorConDescuento = subtotal - descuento
        val iva = (valorConDescuento * 19 )/ 100
        println("IVA (19%): $$iva")
        val total = valorConDescuento + iva
        println("Total: $$total")
    }
}