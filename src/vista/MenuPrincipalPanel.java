package vista;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class MenuPrincipalPanel extends javax.swing.JPanel {

    private JPanel panelContenedor;
    private CardLayout cardLayout;
    

    public MenuPrincipalPanel(JPanel panelContenedor, CardLayout cardLayout) {

        this.panelContenedor = panelContenedor;

        initComponents();
        this.panelContenedor = panelContenedor;
        this.cardLayout = cardLayout;
        
    }

    // Método para navegar entre paneles - úsalo en tus botones
    public void navegarA(String nombrePanel) {
        cardLayout.show(panelContenedor, nombrePanel);
    }

    // Métodos de conveniencia para navegación específica
    public void mostrarRegistroEmpleado() {
        navegarA("registro");
    }

    public void mostrarEmpleadosTerminoFijo() {
        navegarA("fijo");
    }

    public void mostrarEmpleadosTiempoParcial() {
        navegarA("parcial");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistro = new javax.swing.JButton();
        btnFijo = new javax.swing.JButton();
        btnParcial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 255));

        btnRegistro.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnRegistro.setText("Registro de empleados");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnFijo.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnFijo.setText("Empleados término fijo");
        btnFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFijoActionPerformed(evt);
            }
        });

        btnParcial.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnParcial.setText("Empleados tiempo parcial");
        btnParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcialActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnParcial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(880, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnRegistro)
                .addGap(61, 61, 61)
                .addComponent(btnFijo)
                .addGap(87, 87, 87)
                .addComponent(btnParcial)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
    cardLayout.show(panelContenedor,"registro");
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFijoActionPerformed
    cardLayout.show(panelContenedor,"fijo");
    }//GEN-LAST:event_btnFijoActionPerformed

    private void btnParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcialActionPerformed
    cardLayout.show(panelContenedor,"parcial");
    }//GEN-LAST:event_btnParcialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFijo;
    private javax.swing.JButton btnParcial;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
