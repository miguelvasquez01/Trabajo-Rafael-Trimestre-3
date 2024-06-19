package com;

import controller.CategoriaController;
import controller.EmpleadoController;
import controller.ProductoController;

public class EjemploBD {

    public static void main(String[] args) {
        
        
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();

        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
       
        EmpleadoController empleadoController = new EmpleadoController();
        empleadoController.mostrarMenu();
    }
}