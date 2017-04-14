package Modelo;
public class Mesa {
    private Mesero mesero;
    private String id;
    private ListaPedido pedidos;
    private Mesa link;

    public Mesa(String id) {
        this.id = id;
        this.mesero=null;
        this.pedidos = new ListaPedido();
        this.link = null;
    }

    public void setPedidos(ListaPedido pedidos) {
        this.pedidos = pedidos;
    }
    
    public Mesa getLink() {
        return link;
    }

    public void setLink(Mesa link) {
        this.link = link;
    }
    
    public Mesero getMesero() {
        return mesero;
    }

    public ListaPedido getPedidos() {
        return pedidos;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
