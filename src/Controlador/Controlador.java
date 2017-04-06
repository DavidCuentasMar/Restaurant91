/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Vista.GeneralView;
import Vista.MenuView;
import Vista.MeseroView;
import Vista.PlatoView;
import Vista.ProductoView;
import Vista.StockView;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sony
 */
public class Controlador {
    Archivo archivo;

    public Controlador() {
        archivo = new Archivo();
    }
    
    
    public void nuevoProducto(String text, String text0, String text1, String text2, JLabel infoTxt) {
        archivo.nuevoProducto(text,text0,text1,text2,infoTxt);
    }

    public void nuevoPlato(String text, String text0) {
        archivo.nuevoPlato(text,text0);
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

    public void generarMenuMesero(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel) {
        archivo.generarMenuMesero(platosPanel,bebidasPanel,postresPanel);
    }

    
}
