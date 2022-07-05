/*
// Curso Egg FullStack
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto.Producto;

/**
 *
 * @author Ezequiel Balasch
 */
public class productoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {

            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES ('" + producto.getCodigo() + "', "
                    + "'" + producto.getNombre() + "', '" + producto.getPrecio() + "',"
                    + " '" + producto.getCodigo_fabricante() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }

    }
    
    public Producto buscarProductoXCodigo(Integer codigo) throws Exception{
        try {
            String sql = "SELECT * FROM PRODUCTO WHERE codigo = '" + codigo + "'";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE producto SET "
                    + "NOMBRE = '" + producto.getNombre() + "', precio = '" + producto.getPrecio() + "' WHERE "
                    + "codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> listarNombreProducto() throws Exception {
        try {
            String sql = "SELECT NOMBRE FROM PRODUCTO";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarTodoDeProducto() throws Exception {
        try {
            String sql = "SELECT * FROM PRODUCTO";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(4);
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarRangoPrecioProducto() throws Exception {
        try {
            String sql = "SELECT * FROM PRODUCTO WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(4);
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarBaratoProducto() throws Exception {
        try {
            String sql = "SELECT CODIGO,NOMBRE,CODIGO_FABRICANTE,MIN(PRECIO) from producto LIMIT 1;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(4);
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarPortatilProducto() throws Exception {
        try {
            String sql = "select * from producto where nombre like '%Portátil%'";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
}
