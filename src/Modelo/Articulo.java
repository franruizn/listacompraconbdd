/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Articulo {
    // Atributos de la clase Articulo
    private String nombre; // Un atributo para almacenar el nombre del artículo.
    private int unidades; // Un atributo para almacenar la cantidad de unidades del artículo.

    // Constructor de la clase Articulo
    public Articulo(String nombre, int unidades) {
        this.nombre = nombre; // Inicializa el nombre del artículo.
        this.unidades = unidades; // Inicializa la cantidad de unidades del artículo.
    }

    // Métodos de la clase Articulo
    public String getNombre() {
        return nombre; // Devuelve el nombre del artículo.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el nombre del artículo.
    }

    public int getUnidades() {
        return unidades; // Devuelve la cantidad de unidades del artículo.
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades; // Establece la cantidad de unidades del artículo.
    }

    @Override
    public String toString() {
        return "Articulo{" + "nombre=" + nombre + ", unidades=" + unidades + '}'; // Devuelve una representación en cadena del artículo.
    }
}
