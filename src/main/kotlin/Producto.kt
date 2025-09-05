package org.example

class ProductoPrincipal(nombre:String, precio: Float, val premium: Boolean): Producto(nombre, precio) {}

class ProductoBebida(nombre:String, precio:Float,val tamano:String): Producto(nombre,precio){}

open class Producto(val nombre: String, val precio: Float) {
}