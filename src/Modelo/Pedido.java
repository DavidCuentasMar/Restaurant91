package Modelo;

import java.util.StringTokenizer;

public class Pedido {
    public String id;
    public String productos;
    public String mesa;
    public String mesero;
    public Pedido link;

    public Pedido(String id, String productos, String mesa, String mesero) {
        this.id = id;
        this.productos = productos;
        this.mesa = mesa;
        this.mesero = mesero;
        this.link=null;
    }

    public Pedido getLink() {
        return link;
    }

    public void setLink(Pedido link) {
        this.link = link;
    }
    
    public String getProductosTxt() {
        String products="";
        StringTokenizer st = new StringTokenizer(this.productos,"-");
                while(st.hasMoreElements()){
                    String tokenst=st.nextElement().toString();
                    StringTokenizer pt = new StringTokenizer(tokenst,"/");
                    String tokenpt=pt.nextElement().toString();
                    tokenpt=pt.nextElement().toString();
                    products=products+tokenpt+"\n"; 
                }
        
        return products;
    }
    
    
    
}
