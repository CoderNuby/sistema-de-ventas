package Models;

public class Venta {

    public Venta(
            int id,
            int idCliente,
            int sacosVendidos,
            float venta, String fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.sacosVendidos = sacosVendidos;
        this.venta = venta;
        this.fecha = fecha;
    }
    
    int id;
    int idCliente;
    int sacosVendidos;
    float venta;
    String fecha;

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getSacosVendidos() {
        return sacosVendidos;
    }

    public void setSacosVendidos(int sacosVendidos) {
        this.sacosVendidos = sacosVendidos;
    }

    public float getVenta() {
        return venta;
    }

    public void setVenta(float venta) {
        this.venta = venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //////////////////////////////////////////////////////////////////
    
    public void actualizarVente(
            int idCliente,
            int sacosVendidos,
            float venta, String fecha) {
        this.idCliente = idCliente;
        this.sacosVendidos = sacosVendidos;
        this.venta = venta;
        this.fecha = fecha;
    }
}
