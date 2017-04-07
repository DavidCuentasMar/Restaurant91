package Modelo;
public class Cocina {
   ListaPedido pedidos;
    public Cocina( ) {
        pedidos = new ListaPedido();
    }
   
   
   public void agregarPedido(Pedido p){
       this.pedidos.agregarPedido(p);

   }
   public void verPedidosCocina(){
       pedidos.showList();
   }

    public Pedido findPedido(String id) {
        return pedidos.findPedido(id);
    }
}
