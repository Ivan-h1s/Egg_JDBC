package tiendas.menu;
import java.util.Scanner;
import tiendas.service.FabricanteService;
import tiendas.service.ProductoService;

public class Menu {
    
    private Scanner input;
    private ProductoService ps;
    private FabricanteService fs;
    
    public Menu() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.fs = new FabricanteService();
        this.ps = new ProductoService();
    }
    
    public void menuPrincipal() throws Exception {
        int var = 0;
        
        do {            
            try {
                System.out.println(" --- MENU PRINCIPAL ---");
                System.out.println(" 1 - Nombre de todos los productos");
                System.out.println(" 2 - Productos por nombre y precio");
                System.out.println(" 3 - Productos entre $120 y $202");
                System.out.println(" 4 - Lista Portatiles");
                System.out.println(" 5 - Producto más Barato");
                System.out.println(" 6 - Ingresar nuevo producto");
                System.out.println(" 7 - Ingresar Fabricante");
                System.out.println(" 8 - Editar un producto");
                System.out.println(" 9 - SALIR");
                System.out.println(" ----------------------");
                
                var = input.nextInt();

                switch (var) {
                    case 1:
                        System.out.println("NOMBRES DE PRODUCTOS");
                        //eliminarProductoMenu();
                        ps.imprimirNombresProductosPS();
                        System.out.println("\n");
                        break;

                    case 2:
                        System.out.println("NOMBRE Y PRECIOS DE PRODUCTOS");
                        ps.imprimirNombresPreciosProductosPS();
                        System.out.println("\n");
                        break;

                    case 3:
                        System.out.println("PRODUCTOS ENTRE $120 Y $202");
                        ps.imprimirProductosRangoPreciosPS();
                        System.out.println("\n");
                        break;

                    case 4:
                        System.out.println("LISTA DE PORTATILES");
                        ps.imprimirProductosPortatil();
                        System.out.println("\n");
                        break;
                    
                    case 5:
                        System.out.println("PRODUCTO MAS BARATO");
                        ps.imprimirProductoMasBarato();
                        System.out.println("\n");
                        break;

                    case 6:
                        System.out.println("INGRESAR PRODUCTO NUEVO");
                        crearProductoMenu();
                        ps.imprimirProductos();
                        System.out.println("\n");
                        break;

                    case 7:
                        System.out.println("INGRESAR FABRICANTE NUEVO");
                        crearFabricanteMenu();
                        fs.mostrarlistaFabricantes();
                        System.out.println("\n");
                        break;

                    case 8:
                        System.out.println("EDITAR PRODUCTO");
                        editarProductoMenu();
                        ps.imprimirProductos();
                        System.out.println("\n");
                        break;

                    case 9:
                        System.out.println("SALIDA EXITOSA");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception ex) {
                ex.getMessage();
                System.out.println("Entrada invalida\n");
                input.next();
            }
        } while (var != 9);
    }
         
    //crud producto
    public void crearProductoMenu() { //Integer codigo, String nombre, Double precio, Integer cod_fab
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = input.nextInt();
                                    
            System.out.println("INGRESE NOMBRE: ");
            String nombre = input.next();

            System.out.println("INGRESE PRECIO: ");
            double precio = input.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = input.nextInt();

            ps.crearProductoPS(codigo, nombre, precio, cod_fab);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editarProductoMenu() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = input.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = input.next();

            System.out.println("INGRESE PRECIO: ");
            double precio = input.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = input.nextInt();

            ps.editarProductoPS(codigo, nombre, precio, cod_fab);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarProductoMenu() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = input.nextInt();            

            ps.eliminarCodigoPS(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // crud fabricante
    public void crearFabricanteMenu() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = input.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = input.next();

            fs.crearFabricante(codigo, nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}