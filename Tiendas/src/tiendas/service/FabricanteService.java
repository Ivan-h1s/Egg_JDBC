package tiendas.service;
import java.util.Collection;
import tiendas.entidad.Fabricante;
import tiendas.persistencia.FabricanteDAO;

public class FabricanteService {
    
    private FabricanteDAO fdao;

    
    public FabricanteService() {
        this.fdao = new FabricanteDAO();
    }
    
    public void crearFabricante(Integer codigo, String nombre) throws Exception {
               
        try {
            if(codigo == null | codigo < 0) {
                throw new Exception("Error. Debe ingresar un código");
            }
            if(nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("Error. Debe ingresar un nombre");
            }
                        
            Fabricante f = new Fabricante();
            f.setCodigo(codigo);
            f.setNombre(nombre);
            fdao.ingresarFabricante(f);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void mostrarlistaFabricantes() throws Exception {
        try {
            Collection<Fabricante> listaFab = fdao.mostrarFabricantes();
            
            for (Fabricante f : listaFab) {
                System.out.println(f);
            }
            
        } catch (Exception ex) {
            throw ex;
        } 
    }
    
}