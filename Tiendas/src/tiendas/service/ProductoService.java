package tiendas.service;

import java.util.Collection;
import tiendas.entidad.Producto;
import tiendas.persistencia.ProductoDAO;

public class ProductoService {
    
    private ProductoDAO pdao;
    
    public ProductoService() {
        this.pdao = new ProductoDAO();
    }
    
    public void crearProductoPS (Integer codigo, String nombre, Double precio, Integer cod_fab) throws Exception { 
        
        try {
            if (codigo == null | codigo < 0) {
                throw new Exception("Debe ingresar el codigo");
            }
            if(nombre == null | nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar el nombre");
            }
            if (precio == null | precio < 0) {
                throw new Exception("Debe ingresar el precio");
            }
            if (cod_fab == null | cod_fab < 0) {
                throw new Exception("Debe ingresar el codigo del fabricante");
            }            
            
            Producto p = new Producto();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            pdao.ingresarProducto(p);
            
        } catch (Exception ex){            
            throw ex;
        }        
    } 
    
    public void editarProductoPS(Integer codigo, String nombre, Double precio, Integer cod_fab) throws Exception {
        try {            
            if (codigo == null | codigo < 0) {
                throw new Exception("Debe ingresar el codigo");
            }
            if (nombre == null | nombre.trim().isEmpty()) {
                 throw new Exception("Debe ingresar el nombre");
            }
            if (precio == null | precio < 0) {
                throw new Exception("Debe ingresar el precio");
            }
            if (cod_fab == null | cod_fab < 0) {
                throw new Exception("Debe ingresar el codigo del fabricante");
            }
            Producto p = buscarCodigoProductoPS(codigo);

            if (p == null) {
                throw new Exception("Código no asociado a ningún producto");
            }

            //p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            pdao.editarProducto(p);
            
        } catch (Exception ex){            
            throw ex;
        }        
    }
    
    public Collection<Producto> listaNombresProductosPS() throws Exception {
        try {
            Collection<Producto> productos = pdao.listaNombresProductos();
            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void imprimirNombresProductosPS() throws Exception {
        try {
            //Listamos los productos
            Collection<Producto> productos = listaNombresProductosPS();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Collection<Producto> listaNombresPreciosProductoPS() throws Exception {
        try {
            Collection<Producto> productos = pdao.listaNombresPreciosProductos();
            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
     public void imprimirNombresPreciosProductosPS() throws Exception {
        try {            
            Collection<Producto> productos = listaNombresPreciosProductoPS();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {                
                for (Producto p : productos) {
                    System.out.println(p.getNombre() + "\t" + p.getPrecio());
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
     
    public Collection<Producto> listaProductosRangoPreciosPS() throws Exception {
        try {
            Collection<Producto> productos = pdao.listaProductosRangoPrecios();
            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    } 
    
    public void imprimirProductosRangoPreciosPS() throws Exception {
        try {
            //Listamos los productos
            Collection<Producto> productos = listaProductosRangoPreciosPS();
            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Collection<Producto> listaPortatilesPS() throws Exception {
        try {
            Collection<Producto> productos = pdao.listaPortatiles();
            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void imprimirProductosPortatil() throws Exception {
        try {
            //Listamos los productos
            Collection<Producto> productos = listaPortatilesPS();
            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto productoMasBaratoPS() throws Exception {
        try {
            Producto producto = pdao.productoMasBarato();
            return producto;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void imprimirProductoMasBarato() throws Exception {        
        try {            
            Producto producto = productoMasBaratoPS();            
            if(producto == null){
                throw new Exception("No existen productos para imprimir");
            }else{
                System.out.println(producto.getNombre() + "\t" + producto.getPrecio());
            }
           
        } catch (Exception ex) {
            throw ex;
        }
    } 
    
    public Producto buscarCodigoProductoPS(Integer codigo) throws Exception {
        try {
            if(codigo == null) {
              throw new Exception("Debe indicar el codigo");  
            }
            Producto producto = pdao.buscarCodigoProducto(codigo);
            return producto;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void eliminarCodigoPS(Integer codigo) throws Exception {
        try {
            if (codigo == null | codigo < 0) {
                throw new Exception("Debe ingresar el codigo");
            }
            if (pdao.buscarCodigoProducto(codigo) == null) {
                 throw new Exception("Codigo no encontrado");
            }
            pdao.eliminarProducto(codigo);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Collection<Producto> listaProducto() throws Exception {
        try {
            Collection<Producto> productos = pdao.listaProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductos() throws Exception {
        try {            
            Collection<Producto> productos = listaProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}