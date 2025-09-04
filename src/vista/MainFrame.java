package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import servicios.Nomina;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    private CardLayout cardLayout;
    private MenuPrincipalPanel menuPrincipalPanel;
    private PanelEmpleadosCompleto panelEmpleadosCompleto;
    private PanelEmpleadosParcial panelEmpleadosParcial;
    private PanelRegistroEmpleado panelRegistroEmpleado;
    private JPanel panelContenidoPrincipal; // Panel para el contenido que cambia

    // Crear la instancia de Nomina, que será compartida por todos los paneles
    private Nomina nominaManager = new Nomina();

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
        panelRegistroEmpleado = new PanelRegistroEmpleado(panelContenidoPrincipal, cardLayout, nominaManager);
        panelEmpleadosCompleto = new PanelEmpleadosCompleto(panelContenidoPrincipal, cardLayout, nominaManager);
        panelEmpleadosParcial = new PanelEmpleadosParcial(panelContenidoPrincipal, cardLayout, nominaManager);

        // Agregar paneles al CardLayout
        panelContenidoPrincipal.add(panelRegistroEmpleado, "registro");
        panelContenidoPrincipal.add(panelEmpleadosCompleto, "fijo");
        panelContenidoPrincipal.add(panelEmpleadosParcial, "parcial");

        // Crear dashboard (menú lateral)
        menuPrincipalPanel = new MenuPrincipalPanel(panelContenidoPrincipal, cardLayout, nominaManager);
        menuPrincipalPanel.setPreferredSize(new Dimension(280, 0)); // Ancho fijo

        // Configurar layout principal: Dashboard izquierda, contenido centro
        setLayout(new BorderLayout());
        add(menuPrincipalPanel, BorderLayout.WEST);     // Dashboard fijo
        add(panelContenidoPrincipal, BorderLayout.CENTER); // Contenido intercambiable

        // Vista inicial
        cardLayout.show(panelContenidoPrincipal, "registro");
    }
}
