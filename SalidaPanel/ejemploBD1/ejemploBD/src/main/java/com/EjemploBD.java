package com;

import views.MenuPanel;
import controller.CategoriaController;
import controller.EmpleadoController;
import controller.ProductoController;
import javax.swing.JFrame;

public class EjemploBD {

    public static void main(String[] args) {
        
        MenuPanel panel = new MenuPanel();
        
        JFrame frame = new JFrame("Menu");
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();

        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
       
        EmpleadoController empleadoController = new EmpleadoController();
        empleadoController.mostrarMenu();*/
    }
}