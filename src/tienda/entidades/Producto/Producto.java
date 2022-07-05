/*
// Curso Egg FullStack
 */
package tienda.entidades.Producto;

/**
 *
 * @author Ezequiel Balasch
 */
public class Producto {

    private int codigo;
    private String nombre;
    private Double precio;
    private int codigo_fabricante;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Double precio, int codigo_fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    @Override
    public String toString() {
        return "producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigo_fabricante=" + codigo_fabricante + '}';
    }

}
