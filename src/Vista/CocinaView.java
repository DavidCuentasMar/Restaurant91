/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Time;
import Controlador.Controlador;
import Modelo.Cocina;
import Modelo.Mesa;
import Modelo.Mesero;
import Modelo.Pedido;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sony
 */
public class CocinaView extends javax.swing.JFrame implements Runnable{
    private int seg = 0;
    private int min = 0;
    private int hora = 0;
    private int NumVentas=0;
    private boolean continuar = true;
    private Time i;
    Controlador controlador;
    Pedido p;
    Cocina cocinaClass;

    public void setCocinaClass(Cocina cocinaClass) {
        this.cocinaClass = cocinaClass;
    }
    
    public JTable getTablaCocina() {
        return tablaCocina;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    /**
     * Creates new form CocinaView
     */
    public CocinaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCocina = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnCocinar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        TextSeg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCocina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Pedidio", "No.Mesa", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaCocina);

        jButton1.setText("Info.Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCocinar.setText("Cocinar");
        btnCocinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocinarActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("VerPedidos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        TextSeg.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TextSeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextSeg.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(TextSeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCocinar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCocinar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        controlador.verPedidosCocina(cocinaClass);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCocinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocinarActionPerformed
        if (tablaCocina.getSelectedRow()!=-1) {
//            int row = tablaCocina.getSelectedRow();
            int row = 0;
            String NoPedido = tablaCocina.getValueAt(row, 0).toString();
            Pedido p = controlador.actualizarStock(tablaCocina.getValueAt(row, 0).toString());
            System.out.println(p);
            if (p!=null) {
                controlador.findPedido(NoPedido).setProductos(p.getProductos());            
                Pedido pd = new Pedido(p.NroPedido,p.Mesa,p.Camarero,p.getProductos(),p.getProductos().getTamano());
                pd.addPrice(""+p.getValor());
                Mesero mesero = controlador.findMesero(p.Camarero);
                System.out.println("pd price: " + p.getValor());
                mesero.sumTotalVendido(p.getValor());
                System.out.println("totalvendidomeserococin: " + mesero.getTotalVendido());
                mesero.addNumVentas(1);
                this.NumVentas++;
                controlador.addPedidoToMesa(pd);
                continuar = true;
                btnCocinar.setEnabled(false);
                resetSeg();
                i = null;            
                int timeXproductos = p.getLista().getTamano();
                timeXproductos = timeXproductos * 3;            
                System.out.println(timeXproductos);
    //            controlador.verPedidosCocina(cocinaClass);
                i = new Time(this,timeXproductos);
                i.start();
            }else{
                DefaultTableModel model = (DefaultTableModel) tablaCocina.getModel();  
                System.out.println("Pedido NO REALIZADO");    
                controlador.eliminarPedidoCocina(NoPedido);
                model.removeRow(row);
                
            }
            
        }
    }//GEN-LAST:event_btnCocinarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tablaCocina.getSelectedRow()!=-1) {
            int row = tablaCocina.getSelectedRow();
            System.out.println(tablaCocina.getValueAt(row, 0).toString());            
            Pedido p = controlador.findPedido(tablaCocina.getValueAt(row, 0).toString());            
    //        p.showPedidoList();
            String productosTxt = p.getProductosTxt();
                JOptionPane.showMessageDialog(this,
                    "No.Pedido: " + tablaCocina.getValueAt(row, 0).toString()
                    +"\nNo.Mesero:" + p.getCamarero()
                    + "\nNo.Mesa: " + tablaCocina.getValueAt(row, 1).toString()
                    + "\n----------\n" + productosTxt);            
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CocinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CocinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CocinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CocinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CocinaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextSeg;
    private javax.swing.JButton btnCocinar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCocina;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

    }
    public synchronized int aumentSeg() {
        seg++;
        TextSeg.setText(String.valueOf(seg));
        return seg;
    }

    public synchronized int getSeg() {
        return seg;
    }

    public void resetSeg() {
        TextSeg.setText(String.valueOf("0"));
        seg = 0;
    }

    public synchronized boolean isContinuar() {
        return continuar;
    }

    public synchronized void seguir() {
        continuar = true;
    }

    public synchronized void parar() {
        btnCocinar.setEnabled(true);
        continuar = false;        
        DefaultTableModel model = (DefaultTableModel) tablaCocina.getModel();  
//        int row = tablaCocina.getSelectedRow();                  
        int row =0;                  
        String NoPedido = tablaCocina.getValueAt(row, 0).toString();       
        controlador.eliminarPedidoCocina(NoPedido);
        model.removeRow(row);
        
        
    }
}
