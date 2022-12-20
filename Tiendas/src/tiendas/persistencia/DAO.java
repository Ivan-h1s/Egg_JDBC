package tiendas.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false";
    
    protected void conectarDB() throws ClassNotFoundException, Exception {
        try {
            Class.forName(DRIVER);//carga el controlador
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);//establece la conexion
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("Error: " + ex.getMessage());
            throw ex;            
        }
    }
    
    protected void desconectarDB() throws Exception {
        try {
            if(resultado != null) {
                resultado.close();
            }
            if(sentencia != null) {
                sentencia.close();
            }
            if(conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            //System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws Exception{
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            /*try {
                conexion.rollback()
            //correr en workbench 
            //set autocommit = 1
            //commit;            
            } catch (SQLException ex) {
            throw ex;
            
            }*/            
            //System.out.println("Error: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarDB();
        }                
    }
    
    protected  void consultarDB(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            //System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }    
}