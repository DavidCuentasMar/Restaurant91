package Modelo;
public class Cocina {
    private ListaPedido pedidos;
    public Cocina( ) {
        pedidos = new ListaPedido();
    }

    public ListaPedido getPedidos() {
        return pedidos;
        
    }
   
   
   public void agregarPedido(Pedido p){
       this.pedidos.agregarPedido(p);

   }
   public void verPedidosCocina(){
       pedidos.showList();
   }

    public Pedido findPedido(String id) {
        return this.getPedidos().findPedido(id);
    }

    public void eliminarPedidoCocina(String NoPedido) {
        Pedido p = findPedido(NoPedido);
        this.getPedidos().eliminarPedido(p);
    }
    
}
