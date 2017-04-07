package Modelo;
public class ListaPedido {
    Pedido ptr=null;
    Pedido ultimo=null;
    
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

    }
    public void eliminarPedido(String id){
        if (id.equals(this.ptr.id)) {
            Pedido q = this.ptr;
            this.ptr=q.link;
            q.link=null;
        }else{
            Pedido q = this.ptr;
            Pedido ant = q;
            while(!q.id.equals(id)){
                ant=q;
                q=q.getLink();
            }
            ant.setLink(q.getLink());
            q.setLink(null);        
        }
    
    }
    public void showList(){
        Pedido p = this.ptr;
        while(p!=null){
            System.out.println("Pedido id:" + p.id);       
            p=p.link;
        }
    }  

    Pedido findPedido(String id) {
        Pedido q = this.ptr;
        while(!q.id.equals(id)){
            q=q.getLink();
        }
        return q;
    }

    
    


}
