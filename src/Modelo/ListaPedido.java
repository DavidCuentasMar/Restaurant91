package Modelo;
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

    Pedido findPedido(String id) {
        Pedido q = this.ptr;
        while(q.getNroPedido()!=Integer.parseInt(id)){
            q=q.getLink();
        }
        return q;
    }

    
    


}
