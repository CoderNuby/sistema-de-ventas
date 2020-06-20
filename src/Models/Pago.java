package Models;

public class Pago {

    public Pago(int id, int idCliente, float pago, String fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.pago = pago;
        this.fecha = fecha;
    }
    
    
    int id;
    int idCliente;
    float pago;
    String fecha;

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /////////////////////////////////////////////////////////
    public void actualizarPago(float pago, String fecha) {
        this.pago = pago;
        this.fecha = fecha;
    }
    
}
