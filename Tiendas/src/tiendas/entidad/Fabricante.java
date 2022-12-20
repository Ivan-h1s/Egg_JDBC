package tiendas.entidad;

public class Fabricante {
    
    private String nombre;
    private int codigo;

    public Fabricante() {
    }

    public Fabricante(String nombre, int codigoFabricante) {
        this.nombre = nombre;
        this.codigo = codigoFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        //return String.format("%-6s%-15s", codigo, nombre);
        return "Fabricante {" + "nombre= " + nombre + ", codigo= " + codigo + '}';
    }    
}