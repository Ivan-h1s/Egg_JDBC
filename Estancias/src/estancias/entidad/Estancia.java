package estancias.entidad;

import java.time.LocalDate;

public class Estancia {
    private int id_estancia;
    private int Cliente_cliente;
    private int Casa_casa;
    private String nombre_huesped;
    private LocalDate fecha_desde;
    private LocalDate fecha_hasta;

    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public int getCliente_cliente() {
        return Cliente_cliente;
    }

    public void setCliente_cliente(int Cliente_cliente) {
        this.Cliente_cliente = Cliente_cliente;
    }

    public int getCasa_casa() {
        return Casa_casa;
    }

    public void setCasa_casa(int Casa_casa) {
        this.Casa_casa = Casa_casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public LocalDate getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(LocalDate fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public LocalDate getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(LocalDate fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }    
           
}