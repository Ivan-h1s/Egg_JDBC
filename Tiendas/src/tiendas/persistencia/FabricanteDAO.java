package tiendas.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tiendas.entidad.Fabricante;

public class FabricanteDAO extends DAO{
    
    public void ingresarFabricante(Fabricante f) throws Exception {
        try {
            if (f == null) {
                throw new Exception("Error. Debe ingresar un fabricante");
            }
            
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES ('" 
                    + f.getCodigo() + "', '" 
                    + f.getNombre() + "');"; 
            
            insertarModificarEliminar(sql);            
        } catch (Exception ex) {            
            throw ex;
        } finally {
            desconectarDB();
        }
    }
    
    public Collection<Fabricante> mostrarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;" ;
            
            consultarDB(sql);
            
            Fabricante f = null;
            Collection<Fabricante> fabricantes = new ArrayList<>();
                        
            while (resultado.next()) {                
                f = new Fabricante();
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
                fabricantes.add(f);
            }
            desconectarDB();
            return fabricantes;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarDB();
            throw new Exception("Error de sistema");
        }
    }
}