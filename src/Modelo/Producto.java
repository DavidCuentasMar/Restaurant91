package Modelo;
public class Producto {
    private String name;
    private String type;
    private Producto link;

    public Producto(String name, String type) {
        this.name = name;
        this.type = type;
        this.link = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Producto getLink() {
        return link;
    }

    public void setLink(Producto link) {
        this.link = link;
    }
    
    
    
}