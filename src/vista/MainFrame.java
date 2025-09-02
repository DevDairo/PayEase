
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    
    private CardLayout cardLayout;
    private MenuPrincipalPanel menuPrincipalPanel;
    private PanelEmpleadosTerminoFijo panelEmpleadosTerminoFijo;
    private PanelEmpleadosTiempoParcial panelEmpleadosTiempoParcial;
    private PanelRegistroEmpleado panelRegistroEmpleado;
    

   
    public MainFrame() {
        initComponents();
    
    //Impedir pantalla completa
    setResizable(true); 
    //Ancho x alto en píxeles  
    this.setSize(1920,1080);  
   //Configurar la ventana.
    this.setLocationRelativeTo(null); // Centra la ventana.    

    // Inicializa el CardLayout
    cardLayout = new CardLayout();
    panelContenedor = new JPanel(cardLayout);
        
        
    //Inicializa el CardLayout.
    cardLayout = new CardLayout();
    
    // Layout principal
    panelContenedor.setLayout(cardLayout);
    
    // Instancias de los paneles (cartas)
    panelRegistroEmpleado = new PanelRegistroEmpleado(panelContenedor, cardLayout);
    panelEmpleadosTerminoFijo = new PanelEmpleadosTerminoFijo(panelContenedor, cardLayout);
    panelEmpleadosTiempoParcial = new PanelEmpleadosTiempoParcial(panelContenedor, cardLayout);
    
    // Añadir las cartas
    panelContenedor.add(panelRegistroEmpleado, "registro");
    panelContenedor.add(panelEmpleadosTerminoFijo, "fijo");
    panelContenedor.add(panelEmpleadosTiempoParcial, "parcial");
    
    // Menú lateral fijo
    menuPrincipalPanel = new MenuPrincipalPanel(panelContenedor, cardLayout);
    
    // Añadir al JFrame
    add(menuPrincipalPanel, BorderLayout.EAST);
    add(panelContenedor, BorderLayout.CENTER);
    
    // Mostrar primera vista
    cardLayout.show(panelContenedor, "registro");          
        
   }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
