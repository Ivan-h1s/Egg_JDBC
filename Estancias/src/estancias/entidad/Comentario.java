package estancias.entidad;

public class Comentario {
    private int id_comentario;
    private Casa casa;
    private String mensaje;

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Comentario{" + "\nid_comentario= " + id_comentario + ", casa= " + casa + ", \nmensaje= '" + mensaje + "\'" + '}';
    }
      
}