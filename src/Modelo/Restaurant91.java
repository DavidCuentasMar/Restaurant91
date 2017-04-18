package Modelo;
import Vista.GeneralView;
import Vista.PlatoView;
import Vista.ProductoView;
import Controlador.Controlador;
import Vista.CocinaView;
import Vista.GeneralInfoView;
import Vista.MenuView;
import Vista.MesasView;
import Vista.MeseroView;
import Vista.StockView;
public class Restaurant91 {
    ListaMesa mesas;
    ListaMesero meseros;
    public Restaurant91() {
        mesas= new ListaMesa();
        meseros = new ListaMesero();
    }

    public ListaMesa getMesas() {
        return mesas;
    }

    public ListaMesero getMeseros() {
        return meseros;
    }
    public void agregarMesa(Mesa mesa){
        this.mesas.agregarMesa(mesa);
    }
    public void agregarMesero(Mesero mesero){
        this.meseros.agregarMesero(mesero);
    }
    
    public static void main(String[] args) { 
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//        }
        Restaurant91 restaurant = new Restaurant91();
        Controlador controlador = new Controlador();        
        GeneralView generalView = new GeneralView();
        MeseroView  meseroView = new MeseroView();
        GeneralInfoView generalIfoView= new GeneralInfoView();
        generalIfoView.setControlador(controlador);
        StockView stockView = new StockView();
        MesasView mesasView = new MesasView();
        mesasView.setControlador(controlador);
        PlatoView platoView = new PlatoView();
        JefeCocina jefeCocinaClass = new JefeCocina();
        jefeCocinaClass.setControlador(controlador);
        MenuView menuView = new MenuView();
        CocinaView cocinaView = new CocinaView();
        ProductoView productoView = new ProductoView();
        Cocina cocinaClass = new Cocina();
        controlador.setRestaurant(restaurant);
        generalView.setGeneralIfoView(generalIfoView);
        controlador.setMesasViewToGeneralView(mesasView,generalView);
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
        for (int i = 0; i < 20; i++) {
            Mesa mesa = new Mesa((i+1)+"");
            restaurant.getMesas().agregarMesa(mesa);
        }
        for (int i = 0; i < 4; i++) {
            Mesero mesero = new Mesero((i+1)+"");
            restaurant.getMeseros().agregarMesero(mesero);
        }
//        restaurant.getMesas().showList();
//         restaurant.getMeseros().showList();
   }    
    public boolean addMesaToMesero(String mesaId, String meseroId){
        Mesero mesero = findMesero(meseroId);
        boolean ok = mesero.getMesas().validar(mesaId);
        if (ok==true) {
            // actualizo la info de la mesa en el restaurante
            Mesa mesa = findMesa(mesaId);
            if (mesa.getMesero()==null) {
                Mesa aux = new Mesa(mesaId);
                if (mesero.getMesas().agregarMesa(aux,0)==true) {
                    mesa.setMesero(mesero);
                    aux.setMesero(mesero);
                    mesero.getMesas().showList();
                    return true;
                }else{
                    
                    return false;
                }                                                                                               
            }else{
                if (mesa.getMesero()!=mesero) {
                    System.out.println("Esta mesa tiene otro mesero ( "+mesa.getMesero()+" ), [Pedido NO realizado]");
                    return false;
                }
            }                   
            //                        
        }else{
//            System.out.println("Este mesero ya tiene esta mesa,");
        }        
        return true;
    }
    public Mesa findMesa(String id) {
        return this.getMesas().findMesa(id);
    }
    public Mesero findMesero(String id) {
        return this.getMeseros().findMesero(id);
    
    }

    public void addPedidoToMesa(Pedido pd) {
        Mesa mesa = this.getMesas().findMesa(pd.getMesa());
        mesa.getPedidos().agregarPedido(pd);
    }
    public String getFactura(int NroPedido, String Factura,String ID){
        Factura = mesas.Factura(Factura, NroPedido,ID);
        return Factura;
    }
    public String getValorPedido(int NroPedido, String Factura,String ID){
        Factura = mesas.getValorPedido(ID, NroPedido, Factura);
        return Factura;
    }

    public String getMejorMesero() {
        Mesero m = this.meseros.ptr;
        String id="epale";
        int cont = 0;
        while(m!=null){
            System.out.println(m.getTotalVendido());
            if (m.getTotalVendido()>cont){
                id = m.getId();           
                System.out.println("entra");
                cont = m.getTotalVendido();
            }
            m=m.getLink();
        }
//        System.out.println("aaa"+id);
        return id;
    }

    public String getNumVentas() {
        Mesero m = this.meseros.ptr;
        int cont = 0;
        while(m!=null){    
                cont = cont + m.numVentas;           
            m=m.getLink();
        }
        
        return (cont+"");
    }

    public String getMontoMejorMesero(String id) {
        Mesero m = this.meseros.findMesero(id);
        return m.getTotalVendido()+"";
    }
    
}
