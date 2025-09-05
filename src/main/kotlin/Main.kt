package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val gestor = GestorPedido()

    gestor.AnadirProducto(ProductoPrincipal("Hamburguesa", 10000.0f, true),1)
    gestor.AnadirProducto(ProductoBebida("Coca-Cola", 2000.0f, "Grande"),2)

    println("===SISTEMA FOODEXPRESS===")
    gestor.MostrarMenu()
    println("Seleccione productos (números separados por coma): ")
    val productos = readln()
    println("Cliente tipo (regular/vip/premium): ")
    val tipo = readln()

    gestor.AnadirAlCarrito(productos)

    gestor.MostrarCarrito(tipo)
}