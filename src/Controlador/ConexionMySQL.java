/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

public class ConexionMySQL {
    // Atributos de la clase ConexionMySQL
    private final String BD, USUARIO, PASS, HOST; // Información de la base de datos (nombre de la base de datos, usuario, contraseña y host).
    private Connection connection; // Objeto de conexión a la base de datos.
    private TimeZone zonaHoraria; // Zona horaria utilizada para la conexión.

    // Constructor de la clase ConexionMySQL
    public ConexionMySQL(String usuario, String pass, String bd) {
        HOST = "localhost"; // Host de la base de datos (en este caso, "localhost").
        USUARIO = usuario; // Usuario de la base de datos.
        PASS = pass; // Contraseña del usuario de la base de datos.
        BD = bd; // Nombre de la base de datos.
        connection = null; // Inicializa la conexión como nula.
    }

    // Método para establecer la conexión con la base de datos
    public void conectar() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el controlador JDBC para MySQL.
                Calendar now = Calendar.getInstance();
                zonaHoraria = now.getTimeZone(); // Obtiene la zona horaria del sistema.
                // Establece la conexión a la base de datos utilizando la información proporcionada.
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BD + "?user=" + USUARIO + "&password=" + PASS + "&userLegacyDateTimeCode=false&serverTimeZone=" + zonaHoraria.getID());
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
    }

    // Método para cerrar la conexión con la base de datos
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Método para ejecutar consultas SELECT
    public ResultSet ejercutarSelect(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(consulta); // Ejecuta la consulta SELECT y devuelve un conjunto de resultados.
        return rset;
    }

    // Método para ejecutar consultas INSERT, DELETE y UPDATE
    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        int fila = stmt.executeUpdate(consulta); // Ejecuta la consulta INSERT, DELETE o UPDATE y devuelve el número de filas afectadas.
        return fila;
    }
}
