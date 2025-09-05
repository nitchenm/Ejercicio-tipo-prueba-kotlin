package org.example

data class Pendiente(val alo: String): GestorPedidos(){}
data class EnPreparacion(val alo: String): GestorPedidos(){}
data class ListoParaEntrega(val alo: String) : GestorPedidos(){}
data class Error(val alo: String): GestorPedidos(){}

sealed class GestorPedidos {
}