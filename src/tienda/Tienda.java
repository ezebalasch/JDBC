/*
// Curso Egg FullStack
 */
package tienda;

import java.util.Scanner;
import tienda.entidades.Fabricante.FabricanteService;
import tienda.entidades.Producto.ProductoService;

/**
 * @author Ezequiel Balasch
 */
public class Tienda {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        FabricanteService fabricanteService = new FabricanteService();
        ProductoService productoService = new ProductoService();

        try {
            int opcion = 0;
            int salida = 1;
            int valor = 0;
            while (salida == 1) {
                menu();
                opcion = leer.nextInt();
                valor = 0;
                String nombre;
                Integer codigo;
                Double precio;
                Integer codfab;

                switch (opcion) {
                    case 0:
                        salida = 0;
                        break;
                    case 1:
                        System.out.println("Ingrese un nombre de Fabricante");
                        nombre = leer.next();
                        System.out.println("Ingrese un código");
                        codigo = leer.nextInt();
                        fabricanteService.crearFabricante(nombre, codigo);

                        break;
                    case 2:
                        System.out.println("Ingrese código del fabricante a editar");
                        codigo = leer.nextInt();
                        System.out.println("Ingrese nuevo nombre para el fabricante numero " + codigo);
                        nombre = leer.next();
                        fabricanteService.editarFabricante(nombre, codigo);
                        break;
                    case 3:
                        System.out.println("Ingrese código del fabricante a eliminar");
                        codigo = leer.nextInt();
                        fabricanteService.killFabricante(codigo);
                        break;
                    case 4:
                        System.out.println("Ingrese el codigo del producto");
                        codigo = leer.nextInt();
                        System.out.println("Ingrese nombre del producto");
                        nombre = leer.next();
                        System.out.println("Ingrese precio del producto");
                        precio = leer.nextDouble();
                        System.out.println("Ingrese código de fabricante");
                        codfab = leer.nextInt();
                        productoService.crearProducto(codigo, nombre, precio, codfab);
                        break;
                    case 5:
                        System.out.println("Ingrese el codigo del producto a editar");
                        codigo = leer.nextInt();
                        System.out.println("Ingrese el nuevo nombre del producto");
                        nombre = leer.next();
                        System.out.println("Ingrese el nuevo precio del producto");
                        precio = leer.nextDouble();
                        productoService.editarProducto(codigo, nombre, precio);

                        break;
                    case 6:
                        System.out.println("Listando el nombre de todos los productos:");
                        productoService.listaDeNombres();
                        break;
                    case 7:
                        System.out.println("Listando el nombre y precio de los productos:");
                        productoService.listaDeNombresYPrecios();
                        System.out.println("_____________________");
                        break;
                    case 8:
                        System.out.println("Listando productos que su precio esté entre 120 y 202:");
                        productoService.listadoEntrePrecios();
                        break;
                    case 9:
                        System.out.println("Listando portátiles:");
                        productoService.listaPortatil();
                        break;
                    case 10:
                        System.out.println("Listando al más barato");
                        productoService.listaCheaper();
                        break;
                    default: 
                        System.out.println("Por favor ingrese un valor correcto");
                        valor =1;

                }
                System.out.println("");
                if (valor==0) {
                System.out.println("Tarea Completada");                    
                }else{
                    System.out.println("Error");
                }
                System.out.println("");
                System.out.println("");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public static void menu() {
        System.out.println("MENU TIENDA ONLINE");
        System.out.println("");
        System.out.println("A continuación debe seleccionar una opción introduciendo un número");
        System.out.println("1_Crear Fabricante");
        System.out.println("2_Modificar Fabricante");
        System.out.println("3_Eliminar Fabricante");
        System.out.println("......................................................");
        System.out.println("4_Ingrese un producto");
        System.out.println("5_Editar Producto");
        System.out.println("6_Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("7_Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("8_Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("9_Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("10_Listar el nombre y el precio del producto más barato.");
        System.out.println("+++++++++");
        System.out.println("0_SALIDA");
        System.out.println("+++++++++");

        System.out.println("----------------------------------------------------");
    }

}
