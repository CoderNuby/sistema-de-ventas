package Clases;

import Models.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaClientes {
    DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column){  
            return false;  
        }
    };
    JTable table;
    
    public TablaClientes(JTable table){
        this.table = table;
    }
    
    public void cargarClientesTableAllColumns(List<Cliente> list){
        
        ArrayList<Object> nombreColumna = new ArrayList<>();
        nombreColumna.add("");
        nombreColumna.add("Nombre");
        nombreColumna.add("Empresa");
        nombreColumna.add("Ciudad");
        nombreColumna.add("Deuda");
        nombreColumna.add("PrecioVentaSaco");

        
        for(Object columna:nombreColumna){
            model.addColumn(columna);
        }
        
        table.setModel(model);
  
        List<Object[]> datos = new ArrayList<>();
        
        for(Cliente cliente:list){
            datos.add(
                new Object[]{
                    cliente.getId(),
                    cliente.getNombreCliente(),
                    cliente.getNombreEmpresa(),
                    cliente.getCiudad(),
                    cliente.getDeuda(),
                    cliente.getPrecioVentaSaco()
                }
            );
        }
        
        datos.forEach((Object[] datosCliente) -> {
            model.addRow(datosCliente);
        });
        
        table.setModel(model);
        
        
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMaxWidth(243);
        table.getColumnModel().getColumn(1).setMinWidth(0);
        table.getColumnModel().getColumn(1).setPreferredWidth(243);
        
        table.getColumnModel().getColumn(2).setMaxWidth(134);
        table.getColumnModel().getColumn(2).setMinWidth(0);
        table.getColumnModel().getColumn(2).setPreferredWidth(134);
        
        table.getColumnModel().getColumn(3).setMaxWidth(83);
        table.getColumnModel().getColumn(3).setMinWidth(0);
        table.getColumnModel().getColumn(3).setPreferredWidth(83);
        
        table.getColumnModel().getColumn(4).setMaxWidth(50);
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);

        table.getColumnModel().getColumn(5).setMaxWidth(50);
        table.getColumnModel().getColumn(5).setMinWidth(0);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        
    }
    
    public void updateClientesTableAllColumns(List<Cliente> clientes){
        List<Object[]> datos = new ArrayList<>();
        
        for(Cliente cliente:clientes){
            datos.add(
                    new Object[]{
                        cliente.getId(),
                        cliente.getNombreCliente(),
                        cliente.getNombreEmpresa(),
                        cliente.getCiudad(),
                        cliente.getDeuda(),
                        cliente.getPrecioVentaSaco()
                    }
            );
        }
        
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        
        datos.forEach((Object[] datosCliente) -> {
            model.addRow(datosCliente);
        });
        
        table.setModel(model);
    }
    
    public void cargarClientesTable(List<Cliente> list){
        
        ArrayList<Object> nombreColumna = new ArrayList<>();
        nombreColumna.add("");
        nombreColumna.add("Nombre");
        nombreColumna.add("Empresa");
        nombreColumna.add("Ciudad");

        
        for(Object columna:nombreColumna){
            model.addColumn(columna);
        }
        
        table.setModel(model);
  
        List<Object[]> datos = new ArrayList<>();
        
        for(Cliente cliente:list){
            datos.add(
                new Object[]{
                    cliente.getId(),
                    cliente.getNombreCliente(),
                    cliente.getNombreEmpresa(),
                    cliente.getCiudad(),
                }
            );
        }
        
        datos.forEach((Object[] datosCliente) -> {
            model.addRow(datosCliente);
        });
        
        table.setModel(model);
        
        
        table.getColumnModel().getColumn(0).setMaxWidth(0);

        table.getColumnModel().getColumn(0).setMinWidth(0);

        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        

    }
    
    public void updateClientesTable(List<Cliente> clientes){
        List<Object[]> datos = new ArrayList<>();
        
        for(Cliente cliente:clientes){
            datos.add(
                    new Object[]{
                        cliente.getId(),
                        cliente.getNombreCliente(),
                        cliente.getNombreEmpresa(),
                        cliente.getCiudad(),
                    }
            );
        }
        
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        
        datos.forEach((Object[] datosCliente) -> {
            model.addRow(datosCliente);
        });
        
        table.setModel(model);
    }
    
}
