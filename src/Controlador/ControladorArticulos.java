/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Articulo;
import java.sql.*;
import java.util.ArrayList;

public class ControladorArticulos {
    // Atributo de la clase ControladorArticulos
    private final ConexionMySQL conexion; // Un objeto de la clase "ConexionMySQL" para gestionar la conexión a la base de datos.

    // Constructor de la clase ControladorArticulos
    public ControladorArticulos(ConexionMySQL conexion) {
        this.conexion = conexion; // Inicializa la conexión a la base de datos en el constructor.
    }

    // Método para obtener todos los artículos de la lista
    public ArrayList<Articulo> ObtenerTodosArticulos() throws SQLException {
        ArrayList<Articulo> lista = new ArrayList<>(); // Crea una lista para almacenar los artículos recuperados de la base de datos.
        String consulta = "SELECT * FROM compra"; // Define la consulta SQL para seleccionar todos los registros de la tabla "compra" (editar el nombre de la tabla si es necesario).
        ResultSet rset = conexion.ejercutarSelect(consulta); // Ejecuta la consulta SQL utilizando la conexión a la base de datos.

        while (rset.next()) {
            String nombre = rset.getString("nombre"); // Obtiene el valor de la columna "nombre" en el resultado de la consulta (editar el nombre de las columnas según la estructura de la tabla).
            int unidades = rset.getInt("unidades"); // Obtiene el valor de la columna "unidades" en el resultado de la consulta.
            Articulo art = new Articulo(nombre, unidades); // Crea un objeto "Articulo" con los valores recuperados de la base de datos.
            lista.add(art); // Agrega el objeto "Articulo" a la lista.
        }
        return lista; // Devuelve la lista de artículos recuperados de la base de datos.
    }
}
