package Modelo;
public class Mesero {
    private Mesa mesa;
    private String id;
    private ListaMesa mesas;
    private Mesero link;
    int numVentas;
    int NumMesas=0;
    private int totalVendido;

    public int getNumMesas() {
        return NumMesas;
    }

    public int getTotalVendido() {
        return totalVendido;
    }

    public void sumTotalVendido(int totalVendido) {
        this.totalVendido = totalVendido+this.totalVendido;
    }
    
    public int getNumVentas() {
        return numVentas;
    }

    public void addNumVentas(int numVentas) {
        this.numVentas = this.numVentas+numVentas;
    }
    
    public Mesero(String id) {
        this.id = id;
        this.numVentas=0;
        this.mesas = new ListaMesa();
        this.mesa=null;
        this.totalVendido=0;
    }
    public void addMesa(Mesa m){
        this.mesas.agregarMesa(m,0);
        NumMesas++;
    }
    public Mesero getLink() {
        return link;
    }

    public void setLink(Mesero link) {
        this.link = link;
    }
    
    public ListaMesa getMesas() {
        return mesas;
    }

    public void setMesas(ListaMesa mesas) {
        this.mesas = mesas;
    }
    
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
