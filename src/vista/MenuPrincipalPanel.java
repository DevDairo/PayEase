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

        setBackground(new java.awt.Color(102, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
