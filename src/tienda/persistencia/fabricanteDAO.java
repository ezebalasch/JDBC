/*
// Curso Egg FullStack
 */
package tienda.persistencia;

import tienda.entidades.Fabricante.Fabricante;

/**
 *
 * @author Ezequiel Balasch
 */
public class fabricanteDAO extends DAO {
    
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                
            }
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES ('" + fabricante.getCodigo() + "', "
                    + "'" + fabricante.getNombre() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            String sql = "UPDATE fabricante SET "
                    + "NOMBRE = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void eliminarFabricante(Fabricante fabricante) throws Exception{
        try {

            String sql = "DELETE FROM fabricante WHERE codigo = '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }

    /**
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    public Fabricante buscarFabricanteXCodigo(Integer codigo) throws Exception{
        try {
            String sql = "SELECT * FROM FABRICANTE WHERE codigo = '" + codigo + "'";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {                
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                System.out.println("");
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
