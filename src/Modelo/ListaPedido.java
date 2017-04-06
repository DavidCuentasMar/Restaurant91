package Modelo;
public class ListaPedido {
    Pedido ptr;
    Pedido ultimo;
    
    public void agregarPedido(Pedido p){
        if (this.ptr==null) {
            this.ptr=p;
            this.ptr.link=ultimo;            
        }else{
            if (this.ultimo==null) {
                this.ultimo=p;
            }else{
                this.ultimo.link=p;
                this.ultimo=p;                
            }
        }
    }
    public void showList(){
        Pedido p = this.ptr;
        while(p!=null){
            System.out.println("Pedido id:" + p.id);       
            p=p.link;
        }
    }
}
