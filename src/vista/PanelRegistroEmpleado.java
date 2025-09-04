package vista;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.EmpleadoParcial;
import modelo.EmpleadosCompletos;
import servicios.Nomina;

public class PanelRegistroEmpleado extends javax.swing.JPanel {

    private JPanel panelContenedor;
    private CardLayout cardLayout;
    private final Nomina nominaManager;

    public PanelRegistroEmpleado(JPanel panelContenedor, CardLayout cardLayout, Nomina nominaManager) {
        initComponents();
        this.panelContenedor = panelContenedor;
        this.cardLayout = cardLayout;
        this.nominaManager = nominaManager; // USAR el parámetro, NO crear nuevo
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        tipoContrato = new javax.swing.JComboBox<>();
        estadoCivil = new javax.swing.JComboBox<>();
        horasTrabajadas = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel2.setText("Nombre completo");

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel3.setText("Estado civil");

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel4.setText("Horas trabajadas ");

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel5.setText("Tipo de contrato");

        nombre.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N

        tipoContrato.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        tipoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato de tiempo completo", "Contrato de tiempo parcial" }));
        tipoContrato.setToolTipText("");
        tipoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoContratoActionPerformed(evt);
            }
        });

        estadoCivil.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a" }));
        estadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoCivilActionPerformed(evt);
            }
        });

        horasTrabajadas.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(104, 104, 104)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(horasTrabajadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(horasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnRegistrar)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tipoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoContratoActionPerformed

    }//GEN-LAST:event_tipoContratoActionPerformed

    private void estadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoCivilActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    // 1. Capturar los datos del formulario
    String nombreEmpleado = nombre.getText();
    String tipoContratoSeleccionado = (String) tipoContrato.getSelectedItem();
    String estadoCivilSeleccionado = (String) estadoCivil.getSelectedItem();
    String horasTrabajadasStr = horasTrabajadas.getText();

    try {
        // 2. Validar que todos los campos estén completos
        if (nombreEmpleado.isEmpty() || tipoContratoSeleccionado == null || estadoCivilSeleccionado == null || horasTrabajadasStr.isEmpty()) {
            throw new Exception("Faltan datos obligatorios");
        }

        double horasTrabajadasValor = Double.parseDouble(horasTrabajadasStr);

        // 3. Registrar según tipo de contrato
        if ("Contrato de tiempo completo".equals(tipoContratoSeleccionado)) {
            double salarioFijo = 1423500.0;
            EmpleadosCompletos empleadoCompleto = new EmpleadosCompletos(nombreEmpleado, estadoCivilSeleccionado, horasTrabajadasValor, salarioFijo);
            nominaManager.registrarEmpleado(empleadoCompleto);
            JOptionPane.showMessageDialog(null, "Empleado completo registrado con éxito.");

        } else if ("Contrato de tiempo parcial".equals(tipoContratoSeleccionado)) {
            double salarioPorHora = 6189.0;
            EmpleadoParcial empleadoParcial = new EmpleadoParcial(nombreEmpleado, estadoCivilSeleccionado, horasTrabajadasValor, salarioPorHora);
            nominaManager.registrarEmpleado(empleadoParcial);
            JOptionPane.showMessageDialog(null, "Empleado parcial registrado con éxito.");

        } 

        // 4. Limpiar formulario
        nombre.setText("");
        horasTrabajadas.setText("");
        tipoContrato.setSelectedIndex(0);
        estadoCivil.setSelectedIndex(0);

    } catch (Exception ex) {
        // Maneja tanto errores de conversión como campos vacíos
        JOptionPane.showMessageDialog(null, "Error: Todos los campos deben estar completos y las horas deben ser un número válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        nombre.setText("");
        horasTrabajadas.setText("");
        tipoContrato.setSelectedIndex(0);
        estadoCivil.setSelectedIndex(0);
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> estadoCivil;
    private javax.swing.JTextField horasTrabajadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> tipoContrato;
    // End of variables declaration//GEN-END:variables
}
