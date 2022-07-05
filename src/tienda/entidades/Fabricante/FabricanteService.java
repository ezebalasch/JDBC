/*
// Curso Egg FullStack
 */
package tienda.entidades.Fabricante;

import tienda.persistencia.fabricanteDAO;

/**
 *
 * @author Ezequiel Balasch
 */
public class FabricanteService {

    private fabricanteDAO DAO;

    public FabricanteService() {
        this.DAO = new fabricanteDAO();
    }

    public void crearFabricante(String nombre, Integer codigo) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es incorrecto");
            }
            if (codigo.toString() == null) {
                throw new Exception("Debe indicar un código");
            }
            if (DAO.buscarFabricanteXCodigo(codigo) != null) {
                throw new Exception("Ya existe un fabricante con el código mencionado = " + codigo);
            }
            //Se procede a crear el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            DAO.guardarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void editarFabricante(String nombre, Integer codigo) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es incorrecto");
            }
            if (codigo.toString() == null) {
                throw new Exception("Debe indicar un código");
            }
            if (DAO.buscarFabricanteXCodigo(codigo) == null) {
                throw new Exception("Debe seleccionar el código de un fabricante");
            }
            //Se procede a crear el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            DAO.modificarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void killFabricante(Integer codigo) throws Exception {
        try {
            if (codigo.toString() == null) {
                throw new Exception("Debe indicar un código");
            }
            if (DAO.buscarFabricanteXCodigo(codigo) == null) {
                throw new Exception("Debe seleccionar el código de un fabricante");
            }
            //Se procede a crear el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            DAO.eliminarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }
}
