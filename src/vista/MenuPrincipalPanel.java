package vista;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import servicios.Nomina;
import vista.PanelEmpleadosCompleto;

public class MenuPrincipalPanel extends javax.swing.JPanel {

    private JPanel panelContenedor;
    private CardLayout cardLayout;
    private Nomina nominaManager;

    public MenuPrincipalPanel(JPanel panelContenedor, CardLayout cardLayout, Nomina nominaManager) {
        this.panelContenedor = panelContenedor;
        this.cardLayout = cardLayout;
        this.nominaManager = nominaManager; // AGREGAR esta línea
        initComponents();
    }

    // Método para navegar entre paneles
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

        setBackground(java.awt.Color.lightGray);
        setForeground(new java.awt.Color(255, 153, 51));

        btnRegistro.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnRegistro.setText("Registro de empleados");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnFijo.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnFijo.setText("Empleados tiemplo completo");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnParcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFijo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(874, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnRegistro)
                .addGap(54, 54, 54)
                .addComponent(btnFijo)
                .addGap(57, 57, 57)
                .addComponent(btnParcial)
                .addContainerGap(232, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        cardLayout.show(panelContenedor, "registro");
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFijoActionPerformed
        cardLayout.show(panelContenedor, "fijo");
        // Buscar y actualizar el panel después de mostrarlo
        for (int i = 0; i < panelContenedor.getComponentCount(); i++) {
            java.awt.Component comp = panelContenedor.getComponent(i);
            if (comp instanceof PanelEmpleadosCompleto) {
                ((PanelEmpleadosCompleto) comp).llenarTabla(nominaManager);
                break;
            }
        }
    }//GEN-LAST:event_btnFijoActionPerformed

    private void btnParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcialActionPerformed
        cardLayout.show(panelContenedor, "parcial");
        // Buscar y actualizar el panel después de mostrarlo
        for (int i = 0; i < panelContenedor.getComponentCount(); i++) {
            java.awt.Component comp = panelContenedor.getComponent(i);
            if (comp instanceof PanelEmpleadosParcial) {
                ((PanelEmpleadosParcial) comp).llenarTabla(nominaManager);
                break;
            }
        }
    }//GEN-LAST:event_btnParcialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFijo;
    private javax.swing.JButton btnParcial;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
