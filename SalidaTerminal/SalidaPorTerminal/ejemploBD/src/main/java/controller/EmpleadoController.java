package controller;

import dao.EmpleadoDAO;
import java.util.List;
import java.util.Scanner;
import model.Empleado;
import views.EmpleadoView;

public class EmpleadoController {
    
    private EmpleadoDAO empleadoDAO;
    private Scanner scanner;

    public EmpleadoController() {
        empleadoDAO = new EmpleadoDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Empleados ---");
            System.out.println("1. Crear empleado");
            System.out.println("2. Leer empleado");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    leerEmpleados();
                    break;
                case 3:
                    actualizarEmpleados();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearEmpleado() {
        System.out.print("Ingrese el documento del empleado: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el cargo del empleado: ");
        String cargo = scanner.nextLine();
        Empleado empleado = new Empleado(Integer.parseInt(documento), nombre, cargo);
        empleadoDAO.crearEmpleado(empleado);
        EmpleadoView.mostrarMensaje("Empleado creado exitosamente.");
    }

    private void leerEmpleados() {
        List<Empleado> empleados = empleadoDAO.leerEmpleados();
        EmpleadoView.mostrarEmpleados(empleados);
    }

    private void actualizarEmpleados() {
        leerEmpleados();
        System.out.print("\nIngrese el documento del empleado que desea actualizar: ");
        int documento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del empleado: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo cargo del empleado: ");
        String nuevoCargo = scanner.nextLine();
        Empleado empleado = new Empleado(documento, nuevoNombre, nuevoCargo);
        empleadoDAO.actualizarEmpleado(empleado);
        EmpleadoView.mostrarMensaje("Empleado actualizado exitosamente.");
    }

    private void eliminarEmpleado() {
        leerEmpleados();
        System.out.print("\nIngrese el documento del empleado que desea eliminar: ");
        int documento = scanner.nextInt();
        empleadoDAO.eliminarEmpleado(documento);
        EmpleadoView.mostrarMensaje("Empleado eliminado exitosamente.");
    }
}
