
package dao;

import config.ConexionBD;
import model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class EmpleadoDAO {
    private Connection conexion;
    private ConexionBD conexionBD;

    public EmpleadoDAO() { 
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    public void crearEmpleado(Empleado empleado){
        String sql = "INSERT INTO empleados (documento, nombre, cargo) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, empleado.getDocumento());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getCargo());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int documento = resultSet.getInt("documento");
                String nombre = resultSet.getString("nombre");
                String cargo = resultSet.getString("cargo");
                Empleado empleado = new Empleado(documento, nombre, cargo);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return empleados;
    }

    public void actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE productos SET documento = ?, nombre = ?, cargo = ? WHERE documento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, empleado.getDocumento());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getCargo());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int documento) {
        String sql = "DELETE FROM empleados WHERE documento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, documento);
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}
