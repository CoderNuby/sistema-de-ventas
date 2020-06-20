package Models;

import javax.swing.JOptionPane;

public class Cliente {

    public Cliente(
            int id,
            String nombreCliente,
            String nombreEmpresa,
            String ciudad,
            float deuda,
            float precioVentaSaco) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.nombreEmpresa = nombreEmpresa;
        this.ciudad = ciudad;
        this.deuda = deuda;
        this.precioVentaSaco = precioVentaSaco;
    }
    
    //Atributos
    int id;
    String nombreCliente; //Nombre factura
    String nombreEmpresa; //Nombre de la empresa
    String ciudad; //Nombre ciudad
    float deuda;
    float precioVentaSaco;

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public float getPrecioVentaSaco() {
        return precioVentaSaco;
    }

    public void setPrecioVentaSaco(float precioVentaSaco) {
        this.precioVentaSaco = precioVentaSaco;
    }
    
    //////////////////////////////////////////////////////////////////////
    
    public float comprar(float venta){
        this.deuda = this.deuda + venta;
        return deuda;
    }
    
    public float GetInfoCompra(int sacos){
        float compra = (sacos * precioVentaSaco);
        return compra;
    }
    
    
    public boolean pago(float cantidad){
        if((this.deuda - cantidad) < 0){
            JOptionPane.showMessageDialog(null, "cantidad mayor a la deuda");
            return false;
        }
        this.deuda = this.deuda - cantidad;
        return true;
    }
    
    public void actualizarCliente(
            String nombreCliente,
            String nombreEmpresa,
            String ciudad,
            float precioVentaSaco) {
        this.nombreCliente = nombreCliente;
        this.nombreEmpresa = nombreEmpresa;
        this.ciudad = ciudad;
        this.precioVentaSaco = precioVentaSaco;
    }
}
