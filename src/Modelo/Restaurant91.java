package Modelo;
import Vista.GeneralView;
import Vista.PlatoView;
import Vista.ProductoView;
import Controlador.Controlador;
import Vista.CocinaView;
import Vista.MenuView;
import Vista.MeseroView;
import Vista.StockView;
public class Restaurant91 {

    public static void main(String[] args) {  
        Controlador controlador = new Controlador();        
        GeneralView generalView = new GeneralView();
        MeseroView  meseroView = new MeseroView();
        StockView stockView = new StockView();
        PlatoView platoView = new PlatoView();
        JefeCocina jefeCocinaClass = new JefeCocina();
        jefeCocinaClass.setControlador(controlador);
        MenuView menuView = new MenuView();
        CocinaView cocinaView = new CocinaView();
        ProductoView productoView = new ProductoView();
        Cocina cocinaClass = new Cocina();
        controlador.setJefeCocinaClass(jefeCocinaClass);
        controlador.setCocinaClassToCocinaView(cocinaClass,cocinaView);
        controlador.setViewsToStockView(stockView,productoView,platoView);
        controlador.setMenuViewToMeseroView(menuView,meseroView);
        controlador.setControladorToStockView(stockView,controlador);
        controlador.setControladorToGeneralView(generalView,controlador);
        controlador.setCocinaClass(cocinaClass);
        controlador.setControladorToCocinaView(controlador,cocinaView);
        controlador.setControladorToMeseroView(meseroView,controlador);
        controlador.setStockViewToGeneralView(generalView,stockView);
        controlador.setMeseroViewToGeneralView(generalView,meseroView);
        controlador.setCocinaViewToGeneralView(cocinaView,generalView);
        controlador.setMeseroViewToControlador(meseroView,controlador);
        controlador.setCocinaView(cocinaView);
        generalView.setVisible(true);
    }
    
}
