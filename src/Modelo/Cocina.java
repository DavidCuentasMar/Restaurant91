package Modelo;
public class Cocina {
   ListaPedido pedidos;

    public Cocina( ) {
        pedidos = new ListaPedido();
    }
   
   
   public void agregarPedido(String id, String productos,String meseroId, String mesaId){
       Pedido p = new Pedido(id,productos,meseroId,mesaId);
       this.pedidos.agregarPedido(p);

   }
   public void verPedidosCocina(){
       pedidos.showList();
   }

    public Pedido findPedido(String id) {
        return pedidos.findPedido(id);
    }
}
