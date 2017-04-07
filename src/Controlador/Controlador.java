/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Modelo.Cocina;
import Modelo.Pedido;
import Vista.CocinaView;
import Vista.GeneralView;
import Vista.MenuView;
import Vista.MeseroView;
import Vista.PlatoView;
import Vista.ProductoView;
import Vista.StockView;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author sony
 */
public class Controlador {
    Archivo archivo;
    MeseroView meseroView;
    CocinaView cocinaView;
    Cocina cocinaClass;

    public void setCocinaClass(Cocina cocinaClass) {
        this.cocinaClass = cocinaClass;
    }
    
    public void setCocinaView(CocinaView cocinaView) {
        this.cocinaView = cocinaView;
    }
    
    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    

    public void setMeseroView(MeseroView meseroView) {
        this.meseroView = meseroView;
    }
    
    
    public void nuevoProducto(String text, String text0, String text1, String text2, JLabel infoTxt) {
        archivo.nuevoProducto(text,text0,text1,text2,infoTxt);
    }

    public void nuevoPlato(String text, String text0, JPanel panelBotones) {
        archivo.nuevoPlato(text,text0,panelBotones);
    }

    public void setControladorToGeneralView(GeneralView generalView, Controlador controlador) {
        generalView.setControlador(controlador);
    }

    public void setStockViewToGeneralView(GeneralView generalView, StockView stockView) {
        generalView.setStockView(stockView);
    }

    public void setViewsToStockView(StockView stockView, ProductoView productoView, PlatoView platoView) {
        stockView.setPlatoView(platoView);
        stockView.setProductoView(productoView);
    }

    public void setControladorToStockView(StockView stockView, Controlador controlador) {
        stockView.setControlador(controlador);
    }

    public void generarAddMenuPlatos(PlatoView platoView) {
        archivo.generarAddMenuPlatos(platoView.getPanelBotones());
    }

    public void setMeseroViewToGeneralView(GeneralView generalView, MeseroView meseroView) {
       generalView.setMeseroView(meseroView);
    }

    public void setControladorToMeseroView(MeseroView meseroView, Controlador controlador) {
        meseroView.setControlador(controlador);
    }

    public void setMenuViewToMeseroView(MenuView menuView, MeseroView meseroView) {
        meseroView.setMenuView(menuView);
    }

    public void generarMenuMesero(JTable tablaPedido, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
        archivo.generarMenuMesero(tablaPedido, platosPanel,bebidasPanel,postresPanel);
    }

    public void setControladorToArchivo(Archivo archivo, Controlador controlador) {
        archivo.setControlador(controlador);
    }

    public void setMeseroViewToControlador(MeseroView meseroView, Controlador controlador) {
        controlador.setMeseroView(meseroView);
    }

    public void setCocinaViewToGeneralView(CocinaView cocinaView, GeneralView generalView) {
        generalView.setCocinaView(cocinaView);
    }
    
    public JTable getTablaCocina(){
        return this.cocinaView.getTablaCocina();
    }

    public void addPedidoToCocina(String id, String productos, String meseroId, String mesaId) {
        this.cocinaClass.agregarPedido(id,productos,meseroId,mesaId);
    }

    public void setControladorToCocinaView(Controlador controlador, CocinaView cocinaView) {
        cocinaView.setControlador(controlador);
    }


    public void verPedidosCocina(Cocina cocinaClass) {
        cocinaClass.verPedidosCocina();
    }

    public void setCocinaClassToCocinaView(Cocina cocinaClass, CocinaView cocinaView) {
        cocinaView.setCocinaClass(cocinaClass);
    }

    public Pedido findPedido(String id) {
        return cocinaClass.findPedido(id);
    }




    
}
