package vista;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelRegistroEmpleado extends javax.swing.JPanel {

    private JPanel panelContenedor;
    private CardLayout cardLayout;

    public PanelRegistroEmpleado(JPanel panelContenedor, CardLayout cardLayout) {
        initComponents();
        this.panelContenedor = panelContenedor;
        this.cardLayout = cardLayout;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
