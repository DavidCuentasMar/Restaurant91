package Modelo;
public class Cocina {
   int numPedidos=0;
   ListaPedido pedidos;
   
   public void agregarPedido(String productos){
       Pedido p = new Pedido(this.numPedidos+"",productos);
       pedidos.agregarPedido(p);
       this.numPedidos++;
   }
}
