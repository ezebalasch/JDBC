/*
// Curso Egg FullStack
 */
package tienda.entidades.Producto;

import java.util.ArrayList;
import java.util.Collection;
import tienda.persistencia.productoDAO;

/**
 *
 * @author Ezequiel Balasch
 */
public class ProductoService {

    private productoDAO DAO;

    public ProductoService() {
        this.DAO = new productoDAO();
    }

    public void crearProducto(Integer codigo, String nombre, Double precio, Integer codigofab) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es incorrecto");
            }
            if (codigo.toString() == null) {
                throw new Exception("Debe indicar un código");
            }
            if (precio.isNaN()) {
                throw new Exception("Debe indicar un precio");
            }
            if (codigofab.toString() == null) {
                throw new Exception("Debe indicar un código de fabricante");
            }
            if (DAO.buscarProductoXCodigo(codigo) != null) {
                throw new Exception("Ya existe un producto con el código mencionado = " + codigo);
            }
            //Se procede a crear el fabricante
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigofab);
            DAO.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void editarProducto(Integer codigo, String nombre, Double precio) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es incorrecto");
            }
            if (codigo.toString() == null) {
                throw new Exception("Debe indicar un código");
            }
            if (precio.isNaN()) {
                throw new Exception("Debe indicar un precio");
            }

            if (DAO.buscarProductoXCodigo(codigo) == null) {
                throw new Exception("Indique el codigo del producto a editar");
            }
            //Se procede a crear el fabricante
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            DAO.modificarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void listaDeNombres() throws Exception {
        try {
            Collection<Producto> productos = new ArrayList();
            productos = DAO.listarNombreProducto();
            for (Producto producto : productos) {
                System.out.println("_____________________________________");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("_____________________________________");

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listaDeNombresYPrecios() throws Exception {
        try {
            Collection<Producto> productos = new ArrayList();
            productos = DAO.listarTodoDeProducto();
            for (Producto producto : productos) {
                System.out.println("_____________________________________");

                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("_____________________________________");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listadoEntrePrecios() throws Exception {
        try {
            Collection<Producto> productos = new ArrayList();
            productos = DAO.listarRangoPrecioProducto();
            for (Producto producto : productos) {
                System.out.println("_____________________________________");
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Código de Fabricante: " + producto.getCodigo_fabricante());
                System.out.println("_____________________________________");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listaCheaper() throws Exception {
        try {
            Collection<Producto> productos = new ArrayList();
            productos = DAO.listarBaratoProducto();
            for (Producto producto : productos) {
                System.out.println("_____________________________________");
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Código de Fabricante: " + producto.getCodigo_fabricante());
                System.out.println("_____________________________________");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listaPortatil() throws Exception {
        try {
            Collection<Producto> productos = new ArrayList();
            productos = DAO.listarPortatilProducto();
            for (Producto producto : productos) {
                System.out.println("_____________________________________");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("_____________________________________");

            }
        } catch (Exception e) {
            throw e;
        }
    }

}
