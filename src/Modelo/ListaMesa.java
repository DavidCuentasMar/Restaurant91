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
public class ListaMesa {
    Mesa ptr;
    int tamano=1;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    public void agregarMesa(Mesa p){
            if (ptr == null) {
                this.ptr = p;
            } else {
                Mesa q = this.ptr;
                while(q.getLink() != null){
                    q = q.getLink();
                }
                q.setLink(p);            
            }
            tamano++;
            
    }
    public boolean agregarMesa(Mesa p, int a){
        if (this.tamano<=5) {
            if (ptr == null) {
                this.ptr = p;
            } else {
                Mesa q = this.ptr;
                while(q.getLink() != null){
                    q = q.getLink();
                }
                q.setLink(p);            
            }
            tamano++;     
            return true;
        }else{
            System.out.println("Este mesero ya esta con 5 mesas Online");
            return false;
        }                                
    }
    public boolean validar(String id){
        if (this.ptr==null) {
            return true;            
        }else{
            Mesa m = this.ptr;
            while(m!=null){
                if (m.getId().equals(id)) {
                    return false;
                }
                m = m.getLink();
            }
        }       
        return true;
    }
    public void eliminarMesa(Mesa p){
        if (p==this.ptr) {
            Mesa q = this.ptr;
            this.ptr=q.getLink();
            q.setLink(q);
        }else{
            Mesa q = this.ptr;
            Mesa ant = q;
            while(q!=p){
                ant=q;
                q=q.getLink();
            }
            ant.setLink(q.getLink());
            q.setLink(null);        
        }        
        tamano--;
    }
    
    public void showList(){
        Mesa p = this.ptr;
        while(p!=null){
            System.out.println("Mesa id:" + p.getId() + " Mesero id:" + p.getMesero());       
            p=p.getLink();
        }
    }  

    Mesa findMesa(String id) {
        Mesa q = this.ptr;
        while(!q.getId().equals(id) && q!=null){
            q=q.getLink();
        }
        return q;
    }

}
