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

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void nuevoProducto(String tipo, String name, String precio, String cantidad,JLabel infoTxt) {
        System.out.println("Hola");
        try(FileWriter bw = new FileWriter("archivos/productos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);                
                w.write(tipo+","+name+","+precio+","+cantidad);
                w.newLine();
            w.close();
            infoTxt.setText("[ Producto Agregado ]");
        }catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
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
                w.write(name+","+precio+","+ingredientes);
                w.newLine();
                w.close();
            }catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public void generarMenuMesero(JTable tablaPedido, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
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
                        JButton JRB = new JButton(token);        
                        bebidasPanel.add(JRB);
                        JRB.setName(token);
                    }
                    if (token.equals("Postre")) {
                        token=st.nextElement().toString();
                        JButton JRB = new JButton(token);        
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
                        JButton JRB = new JButton(token);        
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
    public int getPrice(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        return Integer.parseInt(st.nextElement().toString());                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
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
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -666;
    }
}
