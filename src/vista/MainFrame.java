package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    private CardLayout cardLayout;
    private MenuPrincipalPanel menuPrincipalPanel;
    private PanelEmpleadosTerminoFijo panelEmpleadosTerminoFijo;
    private PanelEmpleadosTiempoParcial panelEmpleadosTiempoParcial;
    private PanelRegistroEmpleado panelRegistroEmpleado;
    private JPanel panelContenidoPrincipal; // Panel para el contenido que cambia

    public MainFrame() {
        initComponents();

        setupDashboardLayout();

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables

    private void setupDashboardLayout() {
        // Configuración básica de ventana
        setResizable(true);
        setSize(1920, 1080);
        setLocationRelativeTo(null);

        // Remover el panel contenedor generado automáticamente
        remove(panelContenedor);

        // Crear el panel principal con CardLayout para el contenido intercambiable
        cardLayout = new CardLayout();
        panelContenidoPrincipal = new JPanel(cardLayout);

        // Instanciar los paneles de contenido
        panelRegistroEmpleado = new PanelRegistroEmpleado(panelContenidoPrincipal, cardLayout);
        panelEmpleadosTerminoFijo = new PanelEmpleadosTerminoFijo(panelContenidoPrincipal, cardLayout);
        panelEmpleadosTiempoParcial = new PanelEmpleadosTiempoParcial(panelContenidoPrincipal, cardLayout);

        // Agregar paneles al CardLayout
        panelContenidoPrincipal.add(panelRegistroEmpleado, "registro");
        panelContenidoPrincipal.add(panelEmpleadosTerminoFijo, "fijo");
        panelContenidoPrincipal.add(panelEmpleadosTiempoParcial, "parcial");

        // Crear dashboard (menú lateral)
        menuPrincipalPanel = new MenuPrincipalPanel(panelContenidoPrincipal, cardLayout);
        menuPrincipalPanel.setPreferredSize(new Dimension(280, 0)); // Ancho fijo

        // Configurar layout principal: Dashboard izquierda, contenido centro
        setLayout(new BorderLayout());
        add(menuPrincipalPanel, BorderLayout.WEST);     // Dashboard fijo
        add(panelContenidoPrincipal, BorderLayout.CENTER); // Contenido intercambiable

        // Vista inicial
        cardLayout.show(panelContenidoPrincipal, "registro");
    }
}
