/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sony
 */
public class Archivo {
    Controlador controlador;
    ListaProducto productList;
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void nuevoProducto(String tipo, String name, String precio, String cantidad,JLabel infoTxt) {
        try(FileWriter bw = new FileWriter("archivos/productos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);                
                w.write(tipo+","+name+","+precio+","+cantidad+","+0);
                w.newLine();
            w.close();
            infoTxt.setText("[ Producto Agregado ]");
        }catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoPlato(String name, String precio, JPanel panelBotones) {
        if (!name.equals("")) {
            String ingredientes="";
            Component[] component = panelBotones.getComponents();
            for (Component component1 : component) {
                if (component1 instanceof JToggleButton){
                    if (((JToggleButton)component1).isSelected()) {
                       System.out.println(((JToggleButton)component1).getName());
                       ingredientes=ingredientes+((JToggleButton)component1).getName()+"/";
                    }
                }
            }
            ingredientes=ingredientes.substring(0, ingredientes.length()-1);
            try(FileWriter bw = new FileWriter("archivos/platos.txt", true)){         
                BufferedWriter w = new BufferedWriter(bw);                
                w.write(name+","+precio+","+ingredientes+","+0);
                w.newLine();
                w.close();
            }catch (IOException ex) {
//                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }


    public void generarAddMenuPlatos(JPanel panelBotones) {
        panelBotones.removeAll();
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    if (token.equals("Ingrediente")) {
                        token=st.nextElement().toString();
                        JToggleButton JRB = new JToggleButton(token);        
                        panelBotones.add(JRB);
                        JRB.setName(token);
                    }                                                           
                }
                panelBotones.updateUI();
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public void generarMenuMesero(final JTable tablaPedido, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
        platosPanel.removeAll();        bebidasPanel.removeAll();        postresPanel.removeAll();
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    if (token.equals("Bebida")) {
                        token=st.nextElement().toString();
                        String a = st.nextElement().toString();
                        JButton JRB = new JButton(token+" $"+a);         
                        bebidasPanel.add(JRB);
                        JRB.setName(token);
                    }
                    if (token.equals("Postre")) {
                        token=st.nextElement().toString();
                        String a = st.nextElement().toString();
                        JButton JRB = new JButton(token+" $"+a);         
                        postresPanel.add(JRB);
                        JRB.setName(token);
                    }
                }
                bebidasPanel.updateUI();
                postresPanel.updateUI();
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                    String token=st.nextElement().toString();                    
                        String a=st.nextElement().toString();
                        a=token+" $"+a;
                        JButton JRB = new JButton(a);          
                        platosPanel.add(JRB);
                        JRB.setName(token);                
                platosPanel.updateUI();
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Component[] component = platosPanel.getComponents();
        for (Component component1 : component) {
            component1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    addPedidoToTable(tablaPedido, e.getComponent().getName(),"Plato");
                }                   
            });
        }
        Component[] component2 = bebidasPanel.getComponents();
        for (Component component1 : component2) {
            component1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    addPedidoToTable(tablaPedido, e.getComponent().getName(),"Bebida");
                }
             });
        }
        Component[] component3 = postresPanel.getComponents();
        for (Component component1 : component3) {
            component1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    addPedidoToTable(tablaPedido, e.getComponent().getName(),"Postre");                    
                }
             });
        }
    }    
    private void addPedidoToTable(JTable tablaPedido, String name,String type) {
        DefaultTableModel model = (DefaultTableModel) tablaPedido.getModel();
        if (!type.equals("Plato")) {
            model.addRow(new Object[]{type, name, getPrice(name)+""});
        }else{
            model.addRow(new Object[]{type, name, getPricePlato(name)+""});
        }
        
        
    }
        public int comprobarExistencia(String name, String type) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    if (type.equals(token)) {
                        token=st.nextElement().toString();
                        if (name.equals(token)) {
                            token=st.nextElement().toString();
                            token=st.nextElement().toString();
                            return Integer.parseInt(token);                        
                        }                             
                    }               
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -15;
    }
    
    public int getCantidad(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                                    
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -15;
    }

    private int getPricePlato(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();                    
                    if (name.equals(token)) {
                        return Integer.parseInt(st.nextElement().toString());                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
    }

    public int getPrice(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");             
                String token=st.nextElement().toString();    
                token=st.nextElement().toString();
                if (name.equals(token)) {
                       token=st.nextElement().toString();
                       return Integer.parseInt(token);                        
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -666;
    }

    public void archivoTemp(String name, String type, int cant, int price, int num) {
        try(FileWriter bw = new FileWriter("archivos/temp.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
            String cadena;
            try(FileReader f = new FileReader("archivos/productos.txt")){
                BufferedReader b = new BufferedReader(f);            
                while((cadena = b.readLine())!=null) {
//                  System.out.println(cadena);
                    StringTokenizer st = new StringTokenizer(cadena,",");
                    String typeToken = st.nextElement().toString();
                    String nameToken = st.nextElement().toString();
                    String priceToken = st.nextElement().toString();
                    String cantToken = st.nextElement().toString();        
                    System.out.println(cantToken);
                    String NumVecesToken = st.nextElement().toString();                    
                    if (type.equals(typeToken)) {                        
                        if (nameToken.equals(name)) {
                            if (num!=0) {
                                NumVecesToken = (Integer.parseInt(NumVecesToken)+1)+"";
                            }                            
                            w.write(typeToken+","+nameToken+","+priceToken+","+cant+","+NumVecesToken);                       
                        }else{                            
                            w.write(typeToken+","+nameToken+","+priceToken+","+cantToken+","+NumVecesToken);                            
                        }
                        w.newLine();
                    }else{
                        w.write(typeToken+","+nameToken+","+priceToken+","+cantToken+","+NumVecesToken);
                        w.newLine();                    
                    }
                }
                b.close();
            } catch (IOException ex) {
//                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }               
            w.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fichero = new File("archivos/productos.txt");
        fichero.delete();
        File fichero2 = new File("archivos/temp.txt");
        fichero2.renameTo(fichero); 
        
    }

    public String getPlatoIngredientes(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        token=st.nextElement().toString();
                        return token;                        
                    }                                      
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "[PLATO NO ENCONTRADO]";
    }

    public int gerPricePlato(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();                    
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -15;
    }

    public void sumVentaPlato(String name) {
        try(FileWriter bw = new FileWriter("archivos/temp2.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
            String cadena;
            try(FileReader f = new FileReader("archivos/platos.txt")){
                BufferedReader b = new BufferedReader(f);            
                while((cadena = b.readLine())!=null) {
//                  System.out.println(cadena);
                    StringTokenizer st = new StringTokenizer(cadena,",");
                    String nameToken = st.nextElement().toString();
                    String priceToken = st.nextElement().toString();
                    String IngredientesToken = st.nextElement().toString();
                    String NumVecesToken = st.nextElement().toString();    
                    if (nameToken.equals(name)) {
                        NumVecesToken = (Integer.parseInt(NumVecesToken)+1)+"";
                        w.write(nameToken+","+priceToken+","+IngredientesToken+","+NumVecesToken);                       
                    }else{                            
                        w.write(nameToken+","+priceToken+","+IngredientesToken+","+NumVecesToken);                            
                    }
                    w.newLine();
                    
                }
                b.close();
            } catch (IOException ex) {
//                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }               
            w.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fichero = new File("archivos/platos.txt");
        fichero.delete();
        File fichero2 = new File("archivos/temp2.txt");
        fichero2.renameTo(fichero); 
        
    }

    public String getPlatoMasVendido() {
        int cont = 0;
        String mayor="";
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                String name=st.nextElement().toString();   
                String price=st.nextElement().toString();
                String ingredientes=st.nextElement().toString(); 
                String numVecesVendido=st.nextElement().toString();                 
                if (Integer.parseInt(numVecesVendido)>cont) {
                    mayor = name;
                    cont = Integer.parseInt(numVecesVendido);
                }                                   
            }
            b.close();
        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        System.out.println("aaa"+mayor);
        return mayor;

    }

    public String getFacturaT(Pedido p) {
        String factura="";
        Producto a = p.getProductos().getPtr();
        while(a!=null){
            if (a.getType()=="Postre" || a.getType()=="Bebida") {
                factura = factura + a.getName() +".... $"+getPrice(a.getName())+"\n";
            }else{
                factura = factura + a.getName() +".....$"+getPricePlato(a.getName())+"\n";
            }
        a=a.getLink();
        }
        
        return factura;
    }

}
