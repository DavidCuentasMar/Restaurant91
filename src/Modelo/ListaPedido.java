package Modelo;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaPedido {
    Pedido ptr=null;
    Pedido ultimo=null;
    int tamano;
    
    public void agregarPedido(Pedido p){
        if (ptr == null) {
            this.ptr = p;
        } else {
            Pedido q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            q.setLink(p);
        }
        tamano=tamano+1;
    }
    
        public void agregarPedido(Pedido p, int a){
        if (ptr == null) {
            this.ptr = p;
        } else {
            Pedido q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            p.setLink(null);
            q.setLink(p);
        }
        tamano=tamano+1;

    }
    public void eliminarPedido(Pedido p){
        if (p==this.ptr) {
            Pedido q = this.ptr;
            this.ptr=q.getLink();
            q.setLink(q);
        }else{
            Pedido q = this.ptr;
            Pedido ant = q;
            while(q!=p){
                ant=q;
                q=q.getLink();
            }
            ant.setLink(q.getLink());
            q.setLink(null);        
        }        
        tamano=tamano-1;
    }
    
    public void showList(){
        Pedido p = this.ptr;
        while(p!=null){
            System.out.println("Pedido id:" + p.NroPedido);       
            p=p.getLink();
        }
    }  

    public Pedido findPedido(String id) {
        Pedido q = this.ptr;
        while(q.getNroPedido()!=Integer.parseInt(id)){

            q=q.getLink();
        }
        return q;
    }
    
     public void pedidoToTableMesasView(JTable tablaMesas, String mesaID) {
        Pedido p = this.ptr; 
        DefaultTableModel model = (DefaultTableModel) tablaMesas.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
                i=-1;
            }
        while(p!=null){
            if (p.getMesa().equals(mesaID)) {
                model.addRow(new Object[]{p.NroPedido, p.Camarero});                                          
            }         
            p=p.getLink();
        }  
    
    }

 
    
    


}
