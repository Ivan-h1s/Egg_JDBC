package tiendas.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tiendas.entidad.Producto;

public class ProductoDAO extends DAO{
    
    public void ingresarProducto(Producto p) throws Exception {
        try {
            if (p == null) {
                throw new Exception("Error. Debe ingresar un producto");
            }
     
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES ('" + p.getCodigo() + "', '" + p.getNombre() + "', '" + p.getPrecio() + "', '" + p.getCodigoFabricante() + "');"; 
            
            insertarModificarEliminar(sql);            
        } catch (Exception ex) {            
            throw ex;
        } finally {
            desconectarDB();
        }
    }
    
    public void editarProducto(Producto p) throws Exception {
        try {
            if(p == null) {
                throw new Exception("Error. Debe ingresar un producto");
            } 
            
            String sql = "UPDATE producto SET nombre = '" + p.getNombre() + "', "
                    + "precio = '" + p.getPrecio() + "', "
                    + "codigo_fabricante = '" + p.getCodigoFabricante() + "' "
                    + "WHERE codigo = '" + p.getCodigo() + "';";
            
            insertarModificarEliminar(sql); 
        } catch (Exception ex) {            
            throw ex;
        } finally {
            desconectarDB();
        }
    }
    
    public void eliminarProducto(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo = '" + codigo + "';";
            
            insertarModificarEliminar(sql);
        } catch (Exception ex) {            
            throw ex;
        } finally {
            desconectarDB();
        }
    }
    
    public Collection<Producto> listaNombresProductos() throws Exception {
        try {
            String sql = "SELECT nombre from producto";
            
            consultarDB(sql);
            
            Producto p = null;
            Collection<Producto> productos = new ArrayList<>();
            
            while (resultado.next()) {                
                p = new Producto();
                p.setNombre(resultado.getString(1));
                productos.add(p);
            }
            desconectarDB();
            return productos; 
            
        } catch (Exception ex) {
            ex.printStackTrace();            
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Producto> listaNombresPreciosProductos() throws Exception {
        try {
            String sql = "SELECT nombre, precio from producto";
            
            consultarDB(sql);
            
            Producto p = null;
            Collection<Producto> productos = new ArrayList<>();
            
            while (resultado.next()) {                
                p = new Producto();
                p.setNombre(resultado.getString(1));
                p.setPrecio(resultado.getDouble(2));
                productos.add(p);
            }
            desconectarDB();
            return productos;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Producto> listaProductosRangoPrecios() throws Exception {
        try {
            String sql = "SELECT * from producto where precio BETWEEN 120 and 202";
            consultarDB(sql);
            
            Producto p = null;
            
            Collection<Producto> productos = new ArrayList<>();
            
            while (resultado.next()) {                
                p = new Producto();
                                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));                
                p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarDB();
            return productos;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Producto> listaPortatiles() throws Exception {
        try {
            String sql = "SELECT * from producto where nombre like '%portatil%'";
            
            consultarDB(sql);
            
            Producto p = null;
            
            Collection<Producto> productos = new ArrayList<>();
            
            while (resultado.next()) {                
                p = new Producto();
                                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarDB();
            return productos;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
    
   public Producto productoMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio from producto ORDER BY precio ASC LIMIT 1";
            
            consultarDB(sql);
            
            Producto p = null;
                        
            while (resultado.next()) {                
                p = new Producto();                
                p.setNombre(resultado.getString(1));
                p.setPrecio(resultado.getDouble(2));
            }
            desconectarDB();
            return p;
            
        } catch (Exception ex) {            
            desconectarDB();
            throw ex;
        }
    }

    public Producto buscarCodigoProducto(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "';";
            consultarDB(sql);
            
            Producto p = null;
            
            while (resultado.next()) {                
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarDB();
            return p;
            
        } catch (Exception ex) {            
            desconectarDB();
            throw ex;
        }
    }
    
    public boolean verificarFabricante(Integer cod_fab) throws Exception {
        try {            
            String sql = "SELECT * FROM producto WHERE codigo = '" + cod_fab + "';";
            consultarDB(sql);
            return resultado.next();
        } catch (Exception ex) {            
            throw ex;
        } finally {
            desconectarDB();
        }    
    } 
    
    public Collection<Producto> listaProductos() throws Exception {
        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM Producto;";

            consultarDB(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarDB();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
}