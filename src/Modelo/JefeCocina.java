/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.util.StringTokenizer;

/**
 *
 * @author sony
 */
public class JefeCocina {
    Controlador controlador;
    ListaProducto productList;
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    public Pedido actualizarStock(String NoPedido, Cocina cocinaClass) {
        System.out.println("NumeroPedido: " + NoPedido);
        Pedido p = cocinaClass.findPedido(NoPedido); //Buscamos el pedido        
        productList=p.getProductos(); // Tomamos la lista de productos pedidos
        Producto q = productList.getPtr();
        Producto eliminar=q;
        String noCocinados="";
        int noCocinadosPrice=0;
        boolean elim = false;
        while (q!=null){
            if (q.getType().equals("Postre") || q.getType().equals("Bebida")) {
                int price = controlador.getPrice(q.getName());                
                int cant = controlador.getCantidad(q.getName());                
                if (cant>=1) {
                    controlador.archivoTemp(q.getName(),q.getType(),cant-1, price); 
//                    Factura = Factura + q.getName()+".............."+price+"$"+"\n";
                }else{
                    elim = true;
                    eliminar = q;
                    System.out.println(q.getName()+" no tiene en el stock");
//                    //p.setPrice(price);
                    noCocinados=noCocinados+q.getType()+"/"+q.getName()+",";
                    noCocinadosPrice=noCocinadosPrice+price;
                }                                    
            }else{
                String name = q.getName();
                String ingredientesTxt = controlador.getPlatoIngredientes(name);
                System.out.println(ingredientesTxt);
                StringTokenizer st = new StringTokenizer(ingredientesTxt,"/");
                boolean ok=true; //se puede cocinar el plato (todos los ingredientes tienen mas de 1 cant)
                while(st.hasMoreElements() && ok==true){
                    String token=st.nextElement().toString();
                    System.out.println(token);
                    int cant = controlador.getCantidad(token);
                    int price= controlador.getPricePlato(name);
                    if (cant<=0) {
                        ok=false;
                        noCocinadosPrice=noCocinadosPrice+price;
                    }                   
                }
                if (ok==true) {
                    st = new StringTokenizer(ingredientesTxt,"/");
                    while(st.hasMoreElements()){
                        String token=st.nextElement().toString();
//                      System.out.println(token);
                        int cant = controlador.getCantidad(token);
                        int price = controlador.getPrice(token);
                        controlador.archivoTemp(token,"Ingrediente",cant-1, price);       
                    }
//                    Factura = Factura + q.getName()+".........."+archivo.getPrice(name)+"$"+"\n";
                }else{
                    System.out.println("El plato " + name + "no tiene los ingredientes completos"+ "[NO COCINADO]");
                    noCocinados=noCocinados+"Plato/"+name+",";
                    elim=true;
                    eliminar=q;
                }                                  
                
            }
            q=q.getLink();
            if (elim==true) {
                    productList.eliminarProducto(eliminar.getName());
                    elim=false;
            }
        }        
        p.setProductos(productList);
        
        return p;        
        
    
    }
}
