package Modelo;

public class Pedido {
    public int NroPedido;
    public String Mesa;
    public String Camarero;
    private Pedido link;
    private  ListaProducto productos;
    private int valor;
    private int numProductos;
    
    
    public Pedido(int NroPedido, String Mesa, String Camarero, ListaProducto productos, int numProductos) {
        this.NroPedido = NroPedido;
        this.Mesa = Mesa;
        this.Camarero = Camarero;
        this.productos = productos;
        this.numProductos=numProductos;
        this.valor = 0;
    }

    public void setProductos(ListaProducto productos) {
        this.productos = productos;
    }
    
    public Pedido() {
    }
    
    public void showPedidoList(){
        productos.showList();
    }

    public int getNumProductos() {
        return numProductos;
    }
    
 

    public Pedido getLink() {
        return link;
    }

    public void setLink(Pedido link) {
        this.link = link;
    }
    
    public ListaProducto getProductos() {
        return productos;
    }
    public int getNroPedido() {
        return NroPedido;
    }

    public String getMesa() {
        return Mesa;
    }

    public String getCamarero() {
        return Camarero;
    }
    public ListaProducto getLista(){
        return this.productos;
    }
    public String getProductosTxt() {
        return productos.getListTxt();
    }

    public void addPrice(String Monto){
        this.valor = this.valor+Integer.parseInt(Monto);
    }

    public int getValor() {
        return valor;
    }
    
    public void setPrice(int Monto){
        this.valor = this.valor-Monto;
    }
}
