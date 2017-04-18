package Modelo;

import Controlador.Controlador;

public class ListaProducto {
        private Producto ptr=null;
        private Producto ultimo=null;
        int tamano;
        
    public ListaProducto() {
        Controlador controlador = new Controlador();
    }

    public int getTamano() {
        return tamano;
    }
    
    public void eliminarProducto(String name){
        if (name.equals(this.ptr.getName())) {
            Producto q = this.ptr;
            this.ptr=q.getLink();
            q.setLink(null);
        }else{
            Producto q = this.ptr;
            Producto ant = q;
            while(!q.getName().equals(name)){
                ant=q;
                q=q.getLink();
            }
            ant.setLink(q.getLink());
            q.setLink(null);        
        }        
        tamano=tamano-1;
    }
    public void agregarProducto(Producto p){
        if (ptr == null) {
            this.ptr = p;
        } else {
            Producto q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            q.setLink(p);
        }
        tamano=tamano+1;

    }
    public void showList(){
        Producto p = ptr;
        while(p!=null){
            System.out.println(p.getName());
            p=p.getLink();
        }
    }
    public String getListTxt(){
        Producto p = ptr;
        String a = "";
        while(p!=null){
            a=a+p.getName()+"\n";
            p=p.getLink();
        }
        return a;
    }

    public Producto getPtr() {
        return ptr;
    }
    public void setPtr(Producto ptr) {
        this.ptr = ptr;
    }
}
