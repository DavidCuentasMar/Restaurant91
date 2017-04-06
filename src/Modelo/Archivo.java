/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author sony
 */
public class Archivo {

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

    public void nuevoPlato(String name, String precio) {
        try(FileWriter bw = new FileWriter("archivos/platos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
                
                w.write(name+","+precio);
                w.newLine();
            w.close();
        }catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
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

    public void generarMenuMesero(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
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
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }    
}