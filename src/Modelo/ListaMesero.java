/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sony
 */
public class ListaMesero {
    Mesero ptr;
    
    public void agregarMesero(Mesero p){
        if (ptr == null) {
            this.ptr = p;
        } else {
            Mesero q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            q.setLink(p);
        }

    }
    public void eliminarMesero(Mesero p){
        if (p==this.ptr) {
            Mesero q = this.ptr;
            this.ptr=q.getLink();
            q.setLink(q);
        }else{
            Mesero q = this.ptr;
            Mesero ant = q;
            while(q!=p){
                ant=q;
                q=q.getLink();
            }
            ant.setLink(q.getLink());
            q.setLink(null);        
        }        
    }
    
    public void showList(){
        Mesero p = this.ptr;
        while(p!=null){
            System.out.println("Mesero id:" + p.getId());       
            p=p.getLink();
        }
    }  

    Mesero findMesero(String id) {
        Mesero q = this.ptr;
        while(!q.getId().equals(id)){
            q=q.getLink();
        }
        return q;
    }
    
}
