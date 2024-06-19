
package views;

import model.Empleado;
import java.util.List;

public class EmpleadoView {
    public static void mostrarEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados disponibles.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            for (Empleado empleado : empleados) {
                System.out.println(empleado.getDocumento() + ". " + empleado.getNombre() + "- Cargo: " + empleado.getCargo());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
