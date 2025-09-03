import vista.MainFrame;
import modelo.EmpleadoIndefinido;
import modelo.EmpleadoPrestacionServicios;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del sistema de nómina
 * @author Enigma Group
 */
public class App {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App.class.getName());
    
    // Listas para almacenar empleados en memoria (RAM)
    public static List<EmpleadoIndefinido> empleadosIndefinidos = new ArrayList<>();
    public static List<EmpleadoPrestacionServicios> empleadosPrestacionServicios = new ArrayList<>();
    
    public static void main(String[] args) {
        // Configurar Look and Feel
        configurarLookAndFeel();
        
        // Inicializar la interfaz gráfica en el Event Dispatch Thread
        java.awt.EventQueue.invokeLater(() -> {
            try {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            } catch (Exception e) {
                logger.log(java.util.logging.Level.SEVERE, "Error al inicializar la aplicación", e);
            }
        });
    }
    
    /**
     * Configura el Look and Feel de la aplicación
     */
    private static void configurarLookAndFeel() {
        try {
            // Intentar usar Nimbus Look and Feel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.WARNING, "No se pudo configurar el Look and Feel", ex);
        }
    }
}